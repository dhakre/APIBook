package com.book.bookapi.repository;

import com.book.bookapi.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Author findAuthorByBookId(Integer bookId);
}