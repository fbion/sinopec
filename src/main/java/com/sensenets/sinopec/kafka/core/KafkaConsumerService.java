package com.sensenets.sinopec.kafka.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.AbstractIdleService;

public class KafkaConsumerService extends AbstractIdleService {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);
	
	protected KafkaConsumerClient consumer;
	protected KafkaConsumerParam consumerParam;
	protected KafkaMessageHandler messageHandler;
	
	public KafkaConsumerService(KafkaConsumerParam consumerParam, KafkaMessageHandler messageHandler) {
		this.consumerParam = consumerParam;
		this.messageHandler = messageHandler;
	}
	
	protected void startUp() throws Exception {
		log.info("----- STARTING kafka consumer service for [{}]:[{}]", consumerParam.getBootstrapServers(), consumerParam.getTopic());
		consumer = new KafkaConsumerClient(consumerParam, messageHandler);
		try {
			consumer.start();
		} catch (KafkaClientError e) {
			log.error("error starting kafka consumer service.", e);
		}
	}
	
	protected void shutDown() throws Exception {
		log.info("----- STOPPING kafka consumer service for [{}]:[{}]", consumerParam.getBootstrapServers(), consumerParam.getTopic());
		try {
			consumer.stop();
		} catch (KafkaClientError e) {
			log.error("error stopping kafka consumer service.", e);
		}
	}

}
