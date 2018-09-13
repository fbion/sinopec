package com.sensenets.sinopec.kafka.core;

public interface KafkaMessageHandler {
	void handle(KafkaRawMessage message) throws MessageHandlerException, MessageHandlerError;
}
