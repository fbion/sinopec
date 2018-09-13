package com.sensenets.sinopec.kafka.exception;

public class ReservedSpaceLimitException extends FileSystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5074837211818418339L;

	public ReservedSpaceLimitException(String path, long reserved, long free) {
		super(String.format("path: [%s], reserved: %,d bytes, free: %,d bytes", path, reserved, free));
	}
}
