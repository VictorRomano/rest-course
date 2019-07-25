package com.victorromano.restcourse.repository;

import java.util.List;

public interface GenericRepository<T> {

    List<T> findAll(String title);

    T findById(Integer id);

    T save(T book);

    void delete(Integer id);

}
