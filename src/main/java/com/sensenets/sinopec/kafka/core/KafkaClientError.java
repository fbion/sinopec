package com.sensenets.sinopec.kafka.core;

public class KafkaClientError extends Error {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3465712196132651260L;

	public KafkaClientError(String message) {
		super(message);
	}
	
	public KafkaClientError(String message, Throwable cause) {
		super(message, cause);
	}
}
