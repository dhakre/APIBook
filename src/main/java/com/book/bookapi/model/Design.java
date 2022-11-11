package com.book.bookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Design", schema = "BOOK_API_DATA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String category;
    private String colour;
    @Column(name = "basedmovie")
    private String basedMovie;
    @Column(name = "audiobook")
    private String audioBook;

}
