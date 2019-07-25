package com.victorromano.restcourse.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(
                name = "Book.findAll",
                query = "select b from Book b"),
        @NamedQuery(
                name = "Book.findById",
                query = "select b from Book b where b.id = :id"
        )
})
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "Title must not be null")
    @NotEmpty(message = "Title must not be empty")
    private String title;
    @NotNull(message = "Author must not be null")
    @NotEmpty(message = "Author must not be empty")
    private String author;

    @Deprecated
    public Book() {
        // Required by JPA
    }

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
