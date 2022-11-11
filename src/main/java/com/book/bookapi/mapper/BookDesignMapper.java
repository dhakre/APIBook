package com.book.bookapi.mapper;

import com.book.bookapi.model.Book;
import com.book.bookapi.model.Design;
import com.book.bookapi.types.BookDesign;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookDesignMapper {

    @Mapping(source = "book.name", target = "name")
    @Mapping(source = "book.pageCount", target = "pageCount")
    @Mapping(source = "design.id", target = "id")
    @Mapping(source = "design.category", target = "category")
    @Mapping(source = "design.colour", target = "colour")
    @Mapping(source = "design.basedMovie", target = "basedMovie")
    @Mapping(source = "design.audioBook", target = "audioBook")
    @Named("toBookDesign")
    BookDesign toBookDesign(Book book, Design design);

}
