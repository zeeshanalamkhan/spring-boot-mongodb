package com.zeeshan.exception;

public class BookSaveException extends NullPointerException {

	private static final long serialVersionUID = 1L;

	public BookSaveException() {
		super();
	}

	public BookSaveException(String message) {
		super(message);
	}

}
