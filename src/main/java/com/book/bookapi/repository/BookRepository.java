package com.book.bookapi.repository;


import com.book.bookapi.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findBookByName(String name);
}
