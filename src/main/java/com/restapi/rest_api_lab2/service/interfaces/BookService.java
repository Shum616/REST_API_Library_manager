package com.restapi.rest_api_lab2.service.interfaces;

import com.restapi.rest_api_lab2.persistance.entities.Book;

import java.util.List;

public interface BookService {
    Book findBookById(long id);

    List<Book> getAll();

    List<Book> findBookByName(String name);

    Book saveBook(Book book);

    void deleteBookById(Long id);
}
