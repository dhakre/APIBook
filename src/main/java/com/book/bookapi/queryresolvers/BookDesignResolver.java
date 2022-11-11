package com.book.bookapi.queryresolvers;

import com.book.bookapi.mapper.BookDesignMapper;
import com.book.bookapi.model.Book;
import com.book.bookapi.model.Design;
import com.book.bookapi.repository.DesignRepository;
import com.book.bookapi.repository.BookRepository;
import com.book.bookapi.types.BookDesign;
import com.book.bookapi.types.BookFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookDesignResolver {
    final BookRepository bookRepository;
    final DesignRepository designRepository;

    BookDesignMapper bookDesignMapper = Mappers.getMapper(BookDesignMapper.class);

    @QueryMapping
    public BookDesign getDesignedBookByName(@Argument("filter") BookFilter bookFilter) {
        Book book = bookRepository.findBookByName(bookFilter.getName());
        Optional<Design> designOpt = designRepository.findById(book.getId());
        Design design = null;
        if (designOpt.isPresent()) {
            design = designRepository.findById(book.getId()).get();
        }

        return bookDesignMapper.toBookDesign(book, design);
    }

}
