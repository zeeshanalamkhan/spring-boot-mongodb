package com.zeeshan.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeeshan.dao.BookRepository;
import com.zeeshan.domain.Book;
import com.zeeshan.exception.BookNotFoundException;
import com.zeeshan.exception.BookSaveException;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book getBook(Integer id) throws BookNotFoundException {

		logger.info("getBook() execution started");
		Optional<Book> book = bookRepository.findById(id);

		if (!book.isPresent()) {
			logger.warn("Book with ID: " + id + " can not be found");
			throw new BookNotFoundException("Book with ID: " + id + " can not be found");
		}
		logger.info("getBook() execution finished");
		return book.get();
	}

	@Override
	public void saveBook(Book book) throws BookSaveException, BookNotFoundException {

		logger.info("saveBook() execution started");
		if (!bookRepository.existsById(book.getId())) {
			logger.info("saveBook() execution finished");
			bookRepository.save(book);
		} else {
			logger.error("Book with ID: " + book.getId() + " Already exists");
			throw new BookNotFoundException("Book with ID: " + book.getId() + " Already exists");
		}

		if (book.getAuthorName() == null || book.getBookName() == null) {
			logger.error("Book with ID: " + book.getId() + " can not be saved");
			throw new BookSaveException("Book with ID: " + book.getId() + " can not be saved");
		}

	}

	@Override
	public Book updateBook(Integer id, Book book) throws BookNotFoundException {
		logger.info("updateBook() execution started");
		if (!bookRepository.findById(id).isPresent()) {

			logger.error("Book with ID: " + id + "  not found");
			throw new BookNotFoundException("Book with ID: " + id + "  not found");
		}

		Book book1 = new Book();
		book1.setId(id);
		book1.setAuthorName(book.getAuthorName());
		book1.setBookName(book.getBookName());
		bookRepository.save(book1);
		logger.info("updateBook() execution completed");
		return book1;

	}

	@Override
	public void deleteBook(Integer id) throws BookNotFoundException {

		logger.info("deleteBook() execution started");
		if (!bookRepository.findById(id).isPresent()) {
			logger.error("Book with ID: " + id + " can not be found");
			throw new BookNotFoundException("Book with ID: " + id + " can not be found");
		}
		bookRepository.deleteById(id);
		logger.info("deleteBook() execution finished");
	}

	@Override
	public List<Book> getAllBook() throws BookNotFoundException {

		logger.info("getAllBook() execution started");
		List<Book> listBook = bookRepository.findAll();
		if (listBook.size() == 0) {
			logger.info("No Book Found");
			throw new BookNotFoundException("No Book Found");
		}
		logger.info("getAllBook() execution finished");
		return listBook;

	}

}
