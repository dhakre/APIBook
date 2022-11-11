package com.book.bookapi.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDesign implements BookParent{
    Integer id;
    String name;
    String pageCount;
    String category;
    String colour;
    String basedMovie;
    String audioBook;
}
