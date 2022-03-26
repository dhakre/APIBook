package com.book.bookapi.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeletedBook {
    private Integer id;
    private String name;
    private String pageCount;
}
