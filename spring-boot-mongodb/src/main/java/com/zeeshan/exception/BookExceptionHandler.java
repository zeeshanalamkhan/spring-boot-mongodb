package com.zeeshan.exception;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class BookExceptionHandler {

	private static final Logger logger = LogManager.getLogger(BookExceptionHandler.class);
	
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<BookError> noBookHandler(BookNotFoundException ex) {

		logger.info("noBookHandler() execution started");
		BookError error = new BookError();
		error.setErrCode(404);
		error.setDesc(ex.getMessage());
		error.setDate(new Date());
		logger.info("noBookHandler() execution finished");
		return new ResponseEntity<BookError>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(BookSaveException.class)
	public ResponseEntity<BookError> bookNotSaved(NullPointerException ex) {

		logger.info("bookNotSaved() execution started");
		BookError error = new BookError(400, ex.getMessage(), new Date());
		logger.info("bookNotSaved() execution finished");
		return new ResponseEntity<BookError>(error, HttpStatus.BAD_REQUEST);

	}
}
