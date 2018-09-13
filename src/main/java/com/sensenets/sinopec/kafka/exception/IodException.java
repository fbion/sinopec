package com.sensenets.sinopec.kafka.exception;

public class IodException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4782340154661633517L;

	public IodException() {
        super();
    }

    public IodException(String message) {
        super(message);
    }

    public IodException(String message, Throwable cause) {
        super(message, cause);
    }

    public IodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IodException(Throwable cause) {
        super(cause);
    }
}