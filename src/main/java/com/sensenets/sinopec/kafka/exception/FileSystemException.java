package com.sensenets.sinopec.kafka.exception;

public class FileSystemException extends IodException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798502270251532141L;

	public FileSystemException() {
        super();
    }

    public FileSystemException(String message) {
        super(message);
    }

    public FileSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FileSystemException(Throwable cause) {
        super(cause);
    }
}
