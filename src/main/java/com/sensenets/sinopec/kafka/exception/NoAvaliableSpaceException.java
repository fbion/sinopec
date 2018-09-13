package com.sensenets.sinopec.kafka.exception;

public class NoAvaliableSpaceException extends FileSystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2419388888943080411L;
	
	public NoAvaliableSpaceException(String path, long expected, long avaliable) {
		super(String.format("no avaliable space in path [%s], expected: %,d bytes, avaliable: %,d bytes.", path, expected, avaliable));
	}
}
