package com.zeeshan.service;

import java.util.List;

import com.zeeshan.domain.Book;

public interface BookService {

	public Book getBook(Integer id);

	public void saveBook(Book book);

	public Book updateBook(Integer id, Book book);

	public void deleteBook(Integer id);

	public List<Book> getAllBook();
	
}
