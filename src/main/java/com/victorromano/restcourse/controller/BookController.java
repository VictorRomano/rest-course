package com.victorromano.restcourse.controller;

import com.victorromano.restcourse.model.Book;
import com.victorromano.restcourse.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/books")
public class BookController {

    private GenericRepository<Book> bookRepository;

    @Autowired
    public BookController(GenericRepository<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(BookFilter filter) {
        List<Book> books = bookRepository.findAll(filter.getTitle());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(books);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookRepository.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> save(@RequestBody @Valid Book book) {
        bookRepository.save(book);
        return ResponseEntity
                .created(URI.create("/books/" + book.getId()))
                .body(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        bookRepository.save(book);
        return ResponseEntity
                .ok(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        bookRepository.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
