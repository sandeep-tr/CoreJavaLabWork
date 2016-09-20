package com.bootcamp.datevalidator.exception;

public class BadMonth extends Exception {

	private static final long serialVersionUID = 1L;

	public BadMonth(String message) {
		super(message);
	}

	public BadMonth(String message, Throwable cause) {
		super(message, cause);
	}
}
