package com.sensenets.sinopec.kafka.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.util.concurrent.Uninterruptibles;
import com.sensenets.sinopec.kafka.retry.Attempt;
import com.sensenets.sinopec.kafka.retry.RetryException;
import com.sensenets.sinopec.kafka.retry.Retryer;
import com.sensenets.sinopec.kafka.retry.RetryerBuilder;
import com.sensenets.sinopec.kafka.retry.StopStrategy;
import com.sensenets.sinopec.kafka.retry.WaitStrategies;

public class KafkaConsumerRunnable implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerRunnable.class);
	
	private static final long COMMIT_OFFSET_PER_RECORDS = 100;

	private final AtomicBoolean closed = new AtomicBoolean(false);
	private final AtomicBoolean paused = new AtomicBoolean(false);
	private final int partition;
	private final long commitPerMessage;
	private long messageCount;
	private final String topic;
	private final KafkaConsumer<byte[], byte[]> consumer;
	private final KafkaMessageHandler handler;
	private final Optional<MessageHandlerCallback> callbackPossible;
	private final AtomicLong currentOffset;


	public KafkaConsumerRunnable(String topic, int partition, Properties properties, KafkaMessageHandler handler, MessageHandlerCallback callback, long commitPerMessage) {
		this.topic = topic;
		this.partition = partition;
		this.handler = handler;
		this.callbackPossible = Optional.fromNullable(callback);
		this.consumer = new KafkaConsumer<>(properties);
		this.currentOffset = new AtomicLong(-1);
		this.commitPerMessage = commitPerMessage;
	}
	
	public KafkaConsumerRunnable(String topic, int partition, Properties properties, KafkaMessageHandler handler, MessageHandlerCallback callback) {
		this(topic, partition, properties, handler, callback, COMMIT_OFFSET_PER_RECORDS);
	}

	public String getTopic() {
		return topic;
	}

	public int getPartition() {
		return partition;
	}

	public long getCurrentOffset() {
		return currentOffset.get();
	}

	@Override
	public void run() {
		subscribe();

		try {
			while (!closed.get()) {
				if (paused.get()) {
					Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
					continue;
				}

				Optional<ConsumerRecords<byte[], byte[]>> records = Optional.absent();

				try {
					records = Optional.fromNullable(consumer.poll(Integer.MAX_VALUE));
				} catch (WakeupException e) {
					throw e;
				} catch (KafkaException e) {
					log.error(String.format("kafka consumer [%s:%d] -- kafka error!", topic, partition), e);
				} catch (Exception e) {
					log.error(String.format("kafka consumer [%s:%d] -- unknown error!", topic, partition), e);
				}

				if (!records.isPresent()) {
					log.warn("poll kafka records is NULL!");
					continue;
				}

				for (ConsumerRecord<byte[], byte[]> record : records.get()) {
					log.debug("$$$$$ received kafka record. topic:[{}], partition:[{}], offset:[{}]",
						record.topic(), record.partition(), record.offset());
					KafkaRawMessage message = KafkaRawMessage.fromRecord(record);
					if (partition != record.partition()) {
						log.error("invalid partition! expected: {}, got: {}", partition, record.partition());
						continue;
					}

					try {
						tryProcessMessage(message);
						onProcessMessageSuccess(message);
					} catch (ExecutionException e) {
						log.error("error trying to process kafka record.", e);
						onProcessMessageFailure(message, e.getCause());
					} catch (RetryException e) {
						log.error("cancel trying to process kafka record.", e);
						onProcessMessageFailure(message, e);
					} catch (Exception e) {
						log.error("unknown error while trying to process kafka record.", e);
						onProcessMessageFailure(message, e);
					} finally {
						currentOffset.set(message.getOffset() + 1);
						messageCount ++;
					}
				}
				
				if (closed.get() || (messageCount >= commitPerMessage)) {
					try {
						commit();
					} catch (Exception e) {
						log.error("error while commiting offset to kafka!", e);
					}
				}
			}
		} catch (WakeupException e) {
			if (closed.get()) {
				try {
					commit();
				} catch (Exception ex) {
					log.error("error while commiting offset to kafka!", ex);
				}
			} else {
				throw e;
			}
		} catch (Exception e) {
			log.error(String.format("kafka consumer runnable [%s:%d] -- unknown error!", topic, partition), e);
		} finally {
			consumer.close();
		}
	}

	private void tryProcessMessage(final KafkaRawMessage message)
			throws ExecutionException, RetryException {
		Callable<Void> callable = new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				handler.handle(message);
				return null;
			}
		};

		Retryer<Void> retryer = RetryerBuilder.<Void>newBuilder().retryIfExceptionOfType(MessageHandlerException.class)
				.withWaitStrategy(WaitStrategies.<Void>fixedWait(500, TimeUnit.MILLISECONDS))
				.withStopStrategy(new StopStrategy<Void>() {

					@Override
					public boolean shouldStop(Attempt<Void> failedAttempt) {
						return closed.get();
					}
				}).build();

		retryer.call(callable);
	}

	private void subscribe() {
		log.info("##### starting subscribe [{}, {}]", topic, partition);
		TopicPartition partition0 = new TopicPartition(topic, partition);
		consumer.assign(Arrays.asList(partition0));
		messageCount = 0;
		log.info("##### end subscribe [{}, {}]", topic, partition);
	}
	
	private void commit() throws Exception {
		long offset = currentOffset.get();
		if (offset > -1) {
			TopicPartition topicPartition = new TopicPartition(topic, partition);
			OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(offset);
			log.warn("$$$$$ start committing offset. topic: [{}], partition: [{}], offset: [{}]", topic, partition, offset);
			consumer.commitSync(Collections.singletonMap(topicPartition, offsetAndMetadata));
			messageCount = 0;
		}
	}

	public void pause() {
		paused.set(true);
	}

	public void resume() {
		paused.set(false);
	}

	public void shutdown() {
		closed.set(true);
		consumer.wakeup();
	}
	
	private void onProcessMessageSuccess(KafkaRawMessage message) {
		try {
			if (callbackPossible.isPresent()) {
				callbackPossible.get().onSuccess(message);
			}
		} catch (Exception e) {
			log.error("error while invoking handle message callback onSuccess().", e);
		}
	}

	private void onProcessMessageFailure(KafkaRawMessage message, Throwable cause) {
		try {
			if (callbackPossible.isPresent()) {
				callbackPossible.get().onFailure(message, cause);
			}
		} catch (Exception e) {
			log.error("error while invoking handle message callback onFailure().", e);
		}
	}

}
