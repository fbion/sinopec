package com.sensenets.sinopec.kafka.core;

public interface MessageHandlerCallback {
	void onSuccess(KafkaRawMessage message);
	void onFailure(KafkaRawMessage message, Throwable cause);
}
