package com.restapi.rest_api_lab2.persistance.repositories;

import com.restapi.rest_api_lab2.persistance.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByName(String name);

}
