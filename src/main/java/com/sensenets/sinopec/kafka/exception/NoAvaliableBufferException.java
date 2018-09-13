package com.sensenets.sinopec.kafka.exception;

public class NoAvaliableBufferException extends FileSystemException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6633415904869084984L;

	public NoAvaliableBufferException(String path, long expected, long avaliable) {
		super(String.format("no avaliable buffer in file [%s], expected: %,d bytes, avaliable: %,d bytes.", path, expected, avaliable));
	}
}
