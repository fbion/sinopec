package com.sensenets.sinopec.kafka.core;

public class KafkaClientException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8313014189489353519L;

	public KafkaClientException(String message) {
		super(message);
	}
	
	public KafkaClientException(String message, Throwable cause) {
		super(message, cause);
	}
}
