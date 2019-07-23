package com.victorromano.restcourse.repository;

import com.victorromano.restcourse.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
@Repository
public class BookRepositoryInMemory implements BookRepository {

    private static final Map<Integer, Book> books = new HashMap<>();

    public BookRepositoryInMemory() {
        Book domCasmurro = new Book(1, "Dom Casmurro", "Machado de Assis");
        Book aMetamorfose = new Book(2, "A Metamorfose", "Franz Kafka");

        books.put(domCasmurro.getId(), domCasmurro);
        books.put(aMetamorfose.getId(), aMetamorfose);
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>(books.values());
        return bookList;
    }

    @Override
    public Book findById(Integer id) {
        return books.get(id);
    }

    @Override
    public Book save(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public void delete(Integer id) {
        books.remove(id);
    }
}
