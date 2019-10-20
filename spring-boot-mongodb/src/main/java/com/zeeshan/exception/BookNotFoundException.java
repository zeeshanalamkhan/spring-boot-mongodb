package com.zeeshan.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(BookNotFoundException.class);

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
