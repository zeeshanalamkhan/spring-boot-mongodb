package com.zeeshan.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zeeshan.domain.Book;

/**
 * @author ZEESHAN KHAN
 *
 */
public interface BookRepository extends MongoRepository<Book, Integer> {

}
