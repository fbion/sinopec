package com.sensenets.sinopec.kafka.core;

public class MessageHandlerError extends Error {

	/**
	 * 
	 */
	private static final long serialVersionUID = -225464917445601077L;

	public MessageHandlerError(String message) {
		super(message);
	}
	
	public MessageHandlerError(String message, Throwable cause) {
		super(message, cause);
	}
}
