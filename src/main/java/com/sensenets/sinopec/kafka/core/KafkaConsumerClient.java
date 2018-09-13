package com.sensenets.sinopec.kafka.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public final class KafkaConsumerClient {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerClient.class);

	private final AtomicBoolean started;
	private final KafkaConsumerParam param;
	private final KafkaMessageHandler handler;
	private MessageHandlerCallback callback;
	private KafkaConsumer<byte[], byte[]> consumer;

	private ListeningExecutorService consumerExecutorService;

	private final List<KafkaConsumerRunnable> consumerRunnables;

	public KafkaConsumerClient(KafkaConsumerParam param, KafkaMessageHandler handler) {
		this(param, handler, null);
	}

	public KafkaConsumerClient(KafkaConsumerParam param, KafkaMessageHandler handler, MessageHandlerCallback callback) {
		this.started = new AtomicBoolean(false);
		this.param = param;
		this.handler = handler;
		this.callback = callback;
		consumerRunnables = new ArrayList<>();
	}

	public synchronized void start() throws KafkaClientError {
		log.info("STARTING kafka consumer client.");

		if (started.get()) {
			throw new KafkaClientError("kafka consumer is already started.");
		}

		try {
			Preconditions.checkNotNull(param, "kafka consumer param is NULL!");
			Preconditions.checkArgument(!Strings.isNullOrEmpty(param.getBootstrapServers()), "kafka consumer bootstrap server is NULL or EMPTY!");
			Preconditions.checkArgument(!Strings.isNullOrEmpty(param.getTopic()), "kafka consumer topic is NULL or EMPTY!");
			Preconditions.checkArgument(!Strings.isNullOrEmpty(param.getGroupId()), "kafka consumer group id is NULL or EMPTY!");
			Preconditions.checkNotNull(param.getProperties(), "kafka consumer properties is NULL!");
		} catch (Exception e) {
			throw new KafkaClientError("invalid argument!", e);
		}

		String topic = param.getTopic();
		
		Properties properties = getProperties();
		List<PartitionInfo> partitions;

		try {
			consumer = new KafkaConsumer<>(properties);
			partitions = consumer.partitionsFor(topic);
		} catch (KafkaException e) {
			throw new KafkaClientError(String.format("can not fetch patitions for topic: %s", topic), e);
		}

		if ((partitions == null) || (partitions.size() == 0)) {
			throw new KafkaClientError(String.format("no partition info for topic", topic));
		}

		log.warn("kafka partition count for topic [{}]: {}", topic, partitions.size());

		// initial thread pools
		ExecutorService cosumerThreadPool = Executors.newCachedThreadPool(MoreExecutors.platformThreadFactory());
		consumerExecutorService = MoreExecutors.listeningDecorator(cosumerThreadPool);

		for (PartitionInfo partitionInfo : partitions) {
			KafkaConsumerRunnable runnable = new KafkaConsumerRunnable(partitionInfo.topic(), partitionInfo.partition(), properties, handler, callback);
			consumerExecutorService.submit(runnable);
			consumerRunnables.add(runnable);
		}

		started.set(true);
	}

	private Properties getProperties() {
		Properties properties = param.getProperties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, param.getBootstrapServers());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, param.getGroupId());
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.ByteArrayDeserializer");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.ByteArrayDeserializer");

		return properties;
	}

	public synchronized void pause() throws KafkaClientError {
		for (KafkaConsumerRunnable runnable : consumerRunnables) {
			runnable.pause();
		}
	}

	public synchronized void resume() throws KafkaClientError {
		for (KafkaConsumerRunnable runnable : consumerRunnables) {
			runnable.resume();
		}
	}


	public synchronized void stop() {
		log.info("STOPPING kafka consumer client.");

		if (!started.get()) {
			throw new KafkaClientError("kafka consumer is not started yet.");
		}

		// stop consumers
		for (KafkaConsumerRunnable runnable : consumerRunnables) {
			runnable.shutdown();
		}

		consumerRunnables.clear();

		// destroy thread pools
		consumerExecutorService.shutdown();
		
		consumer.close();
		started.set(false);
	}
}
