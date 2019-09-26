package com.zeeshan.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class BookExceptionHandler {

	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<BookError> noBookHandler(BookNotFoundException ex) {

		BookError error = new BookError();
		error.setErrCode(404);
		error.setDesc(ex.getMessage());
		error.setDate(new Date());
		return new ResponseEntity<BookError>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(BookSaveException.class)
	public ResponseEntity<BookError> bookNotSaved(NullPointerException ex) {

		BookError error = new BookError(400, ex.getMessage(), new Date());
		return new ResponseEntity<BookError>(error, HttpStatus.BAD_REQUEST);

	}
}
