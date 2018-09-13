package com.sensenets.sinopec.kafka.exception;

public class CacheCadidateException extends IodException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6432227363618655978L;
	
    public CacheCadidateException(String message) {
        super(message);
    }

    public CacheCadidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheCadidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CacheCadidateException(Throwable cause) {
        super(cause);
    }
}