package com.victorromano.restcourse.repository;

import com.victorromano.restcourse.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll(String title);

    Book findById(Integer id);

    Book save(Book book);

    void delete(Integer id);

}
