package com.victorromano.restcourse.repository;

import com.victorromano.restcourse.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Repository
@Transactional
public class BookRepositoryJpa implements GenericRepository<Book> {

    private EntityManager entityManager;

    @Autowired
    public BookRepositoryJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAll(String title) {
//        return entityManager
//                .createNamedQuery("Book.findAll", Book.class)
//                .getResultList();

        String query = "select b from Book b ";

        if (title != null) {
            query = query + " where title = :title";
        }

        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        typedQuery.setParameter("title", title);
        return typedQuery.getResultList();
    }

    @Override
    public Book findById(Integer id) {
        return entityManager
                .createNamedQuery("Book.findById", Book.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
        return book;
    }

    @Override
    public void delete(Integer id) {
        Book bookToDelete = entityManager.find(Book.class, id);
        entityManager.remove(bookToDelete);
    }
}
