package com.sensenets.sinopec.kafka.core;

public class MessageHandlerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6221792055749572695L;

	public MessageHandlerException(String message) {
		super(message);
	}
	
	public MessageHandlerException(String message, Throwable cause) {
		super(message, cause);
	}
}
