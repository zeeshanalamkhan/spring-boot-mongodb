package com.zeeshan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeeshan.dao.BookRepository;
import com.zeeshan.domain.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book getBook(Integer id) {

		Book book = bookRepository.findById(id).get();
		return book;

	}

	@Override
	public void saveBook(Book book) {

		bookRepository.save(book);

	}

	@Override
	public Book updateBook(Integer id, Book book) {

		Book book1 = bookRepository.findById(id).get();
		book1.setAuthorName(book.getAuthorName());
		book1.setBookName(book.getBookName());
		bookRepository.save(book1);
		return book1;

	}

	@Override
	public void deleteBook(Integer id) {

		bookRepository.deleteById(id);

	}

	@Override
	public List<Book> getAllBook() {

		List<Book> listBook = bookRepository.findAll();
		return listBook;

	}

}
