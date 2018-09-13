package com.sensenets.sinopec.kafka.core;

import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;

public class kafkaProducerListClient implements Closeable {
	private static final Logger log = LoggerFactory.getLogger(kafkaProducerListClient.class);
	
	private Producer<String, byte[]> producer;
	
	public kafkaProducerListClient() {		
	}

	public void open(String bootstrapServers, Properties properties) throws KafkaClientException {
		try {
			if (!Strings.isNullOrEmpty(bootstrapServers)) {
				properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
			}
			producer = new KafkaProducer<String, byte[]>(properties);
		} catch (KafkaException ex) {
			log.debug("kafka error while opening kafka producer!", ex);
			throw new KafkaClientException("kafka error while opening kafka producer!", ex);
		} catch (Exception ex) {
			log.debug("unknown error while opening kafka producer!", ex);
			throw new KafkaClientException("unknown error while opening kafka producer!", ex);
		}
	}
	
	public void send(String topic,  byte[] message) throws KafkaClientException {
		try {
			ProducerRecord<String, byte[]> record = new ProducerRecord<String, byte[]>(topic, message);
			log.debug("START sending list kafka message. topic: [{}]", topic);
			RecordMetadata metadata = producer.send(record).get();
			log.debug("kafka send list successfully!. topic: [{}], metadata: [{}]", topic, metadata.toString());
		} catch (KafkaException ex) {
			throw new KafkaClientException(String.format("kafka error: kafka send list failed!. topic: [%s]", topic), ex);
		} catch (Exception ex) {
			throw new KafkaClientException(String.format("unknown error: kafka send list failed!. topic: [%s]", topic), ex);
		}
	}
	
	@Override
	public void close() throws IOException {
		try {
			producer.close();
		} catch (KafkaException ex) {
			log.error("error while closing kafka producer!", ex);
		}
	}
}
