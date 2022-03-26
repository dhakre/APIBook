package com.book.bookapi.queryresolvers;

import com.book.bookapi.model.Book;
import com.book.bookapi.types.BookInput;
import com.book.bookapi.types.DeleteBookInput;
import com.book.bookapi.types.DeletedBook;
import com.book.bookapi.types.NewBook;
import com.book.bookapi.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class BookMutation implements GraphQLMutationResolver {

    BookRepository bookRepository;

    public NewBook newBook(BookInput bookInput){
        Book book =  new Book();
        book.setName(bookInput.getName());
        book.setPageCount(bookInput.getPageCount());
        Book book1 = bookRepository.save(book);
        return new NewBook(book1.getId(),book1.getName(),book1.getPageCount());
    }

    public DeletedBook deleteBook(DeleteBookInput deleteBookInput){
        Book deleteBook = new Book();
        Optional<Book> findBook =  bookRepository.findById(deleteBookInput.getId());
        if(findBook.isPresent()){
            bookRepository.delete(findBook.get());
            deleteBook = findBook.get();
        }
        return new DeletedBook(deleteBook.getId(), deleteBook.getName(), deleteBook.getPageCount());
    }
}
