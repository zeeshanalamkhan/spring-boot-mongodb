package com.zeeshan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.domain.Book;
import com.zeeshan.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/save")
	public String saveBook(@RequestBody Book book) {

		bookService.saveBook(book);
		return "Book added with ID: " + book.getId();

	}

	@GetMapping("/findBookById/{id}")
	public Book findBookById(@PathVariable Integer id) {

		return bookService.getBook(id);

	}

	@GetMapping("/findAllBooks")
	public List<Book> getAllBook() {

		return bookService.getAllBook();

	}

	@PutMapping("/updateBook/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {

		bookService.updateBook(id, book);
		return bookService.getBook(id);

	}

	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable Integer id) {

		bookService.deleteBook(id);
		return " Book with ID: " + id + " deleted successfully...";

	}

}
