package com.book.bookapi.queryresolvers;


import com.book.bookapi.enums.ListOrder;
import com.book.bookapi.model.Author;
import com.book.bookapi.model.Book;
import com.book.bookapi.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
@AllArgsConstructor
public class BookAuthorResolver implements GraphQLResolver<Book> {

    AuthorRepository authorRepository;

    public Iterable<Author> getAuthor(Book book, ListOrder order) {
        List<Author> allAuthors = (List<Author>) authorRepository.findALLByBookId(book.getId());
        if (order != null) {
            switch (order) {
                case ASC:
                    allAuthors.sort(Comparator.comparingInt(Author::getStarRating));
                case DESC:
                    allAuthors.sort(Comparator.comparingInt(Author::getStarRating).reversed());
            }
        }
        return allAuthors;
    }
}
