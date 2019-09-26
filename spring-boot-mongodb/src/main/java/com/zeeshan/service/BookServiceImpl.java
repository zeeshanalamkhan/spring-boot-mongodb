package com.zeeshan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeeshan.dao.BookRepository;
import com.zeeshan.domain.Book;
import com.zeeshan.exception.BookNotFoundException;
import com.zeeshan.exception.BookSaveException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book getBook(Integer id) throws BookNotFoundException {

		Optional<Book> book = bookRepository.findById(id);

		if (!book.isPresent()) {
			throw new BookNotFoundException("Book with ID: " + id + " can not be found");
		}

		return book.get();
	}

	@Override
	public void saveBook(Book book) throws BookSaveException, BookNotFoundException {

		if (!bookRepository.existsById(book.getId())) {

			bookRepository.save(book);
		} else {

			throw new BookNotFoundException("Book with ID: " + book.getId() + " Already exists");
		}

		if (book.getAuthorName() == null || book.getBookName() == null) {
			throw new BookSaveException("Book with ID: " + book.getId() + " can not be saved");
		}

	}

	@Override
	public Book updateBook(Integer id, Book book) throws BookNotFoundException {

		if (!bookRepository.findById(id).isPresent()) {

			throw new BookNotFoundException("Book with ID: " + id + "  not found");
		}

		Book book1 = new Book();
		book1.setId(id);
		book1.setAuthorName(book.getAuthorName());
		book1.setBookName(book.getBookName());
		bookRepository.save(book1);
		return book1;

	}

	@Override
	public void deleteBook(Integer id) throws BookNotFoundException {

		if (!bookRepository.findById(id).isPresent()) {
			throw new BookNotFoundException("Book with ID: " + id + " can not be found");
		}
		bookRepository.deleteById(id);

	}

	@Override
	public List<Book> getAllBook() throws BookNotFoundException {

		List<Book> listBook = bookRepository.findAll();
		if (listBook.size() == 0) {
			throw new BookNotFoundException("No Book Found");
		}
		return listBook;

	}

}
