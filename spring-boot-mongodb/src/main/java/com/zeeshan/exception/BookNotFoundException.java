package com.zeeshan.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookNotFoundException(String message) {
		super(message);
	}

	public BookNotFoundException(Throwable cause) {
		super(cause);
	}

}
