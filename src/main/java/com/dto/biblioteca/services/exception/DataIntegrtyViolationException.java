package com.dto.biblioteca.services.exception;

public class DataIntegrtyViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrtyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrtyViolationException(String message) {
		super(message);
	}

}
