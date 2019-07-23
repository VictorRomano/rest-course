package com.victorromano.restcourse.controller;

import com.victorromano.restcourse.model.Book;
import com.victorromano.restcourse.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookRepository.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(books);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findById(@PathVariable Integer id) {
        return bookRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        bookRepository.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
