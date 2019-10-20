package com.zeeshan.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.domain.Book;
import com.zeeshan.exception.BookNotFoundException;
import com.zeeshan.exception.BookSaveException;
import com.zeeshan.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2BookController", description = "This REST Api related to BookController!!!!")
@RestController
public class BookController {

	private static final Logger logger = LogManager.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@ApiOperation(value = "Saving new book entity into BookRepository", response = String.class, tags = "saveBook")
	@PostMapping("/save")
	public String saveBook(@RequestBody Book book) throws BookNotFoundException, BookSaveException {

		logger.info("saveBook() execution started");
		bookService.saveBook(book);
		logger.info("saveBook() execution finished");
		return "Book added with ID: " + book.getId();

	}

	@ApiOperation(value = "get Book from BookRepository using bookId", response = Book.class, tags = "findBookById")
	@GetMapping("/findBookById/{id}")
	public Book findBookById(@PathVariable Integer id) throws BookNotFoundException {
		logger.info("findBookById() execution started");
		return bookService.getBook(id);

	}

	@ApiOperation(value = "getting All Books from BookRepository", response = Iterable.class, tags = "findAllBook")
	@GetMapping("/findAllBooks")
	public List<Book> getAllBook() throws BookNotFoundException {

		logger.info("findAllBook() execution started");
		return bookService.getAllBook();

	}

	@ApiOperation(value = "updating a Books", response = Book.class, tags = "updateBook")
	@PutMapping("/updateBook/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) throws BookNotFoundException {

		logger.info("updateBook() execution started");
		bookService.updateBook(id, book);
		logger.info("updtaeBook() execution finished");
		return bookService.getBook(id);

	}

	@ApiOperation(value = "deleting a book", response = String.class, tags = "deleteBook")
	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable Integer id) throws BookNotFoundException {

		logger.info("deleteBook() execution started");
		bookService.deleteBook(id);
		logger.info("deleteBook() execution finished");
		return " Book with ID: " + id + " deleted successfully...";

	}

}
