package com.book.bookapi.queryresolvers;


import com.book.bookapi.model.Author;
import com.book.bookapi.model.Book;
import com.book.bookapi.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorResolver implements GraphQLResolver<Book> {

    @Autowired
    AuthorRepository authorRepository;

    public Author getAuthor(Book book){
        return authorRepository.findAuthorByBookId(book.getId());
    }
}
