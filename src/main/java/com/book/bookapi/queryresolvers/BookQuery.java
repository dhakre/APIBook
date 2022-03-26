package com.book.bookapi.queryresolvers;

import com.book.bookapi.model.Author;
import com.book.bookapi.model.Book;
import com.book.bookapi.types.BookFilter;
import com.book.bookapi.repository.AuthorRepository;
import com.book.bookapi.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class BookQuery implements GraphQLQueryResolver{

    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public Iterable<Book> allBook(){
        return bookRepository.findAll();
    }

    public Book getBookByName(BookFilter bookFilter){
        return bookRepository.findBookByName(bookFilter.getName());
    }

    public Iterable<Author> allAuthor(){
        return authorRepository.findAll();
    }

}
