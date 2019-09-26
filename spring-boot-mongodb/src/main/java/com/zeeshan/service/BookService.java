package com.zeeshan.service;

import java.util.List;

import com.zeeshan.domain.Book;
import com.zeeshan.exception.BookNotFoundException;
import com.zeeshan.exception.BookSaveException;

public interface BookService {

	public Book getBook(Integer id) throws BookNotFoundException;

	public void saveBook(Book book) throws BookSaveException, BookNotFoundException;

	public Book updateBook(Integer id, Book book) throws BookNotFoundException;

	public void deleteBook(Integer id) throws BookNotFoundException;

	public List<Book> getAllBook() throws BookNotFoundException;

}
