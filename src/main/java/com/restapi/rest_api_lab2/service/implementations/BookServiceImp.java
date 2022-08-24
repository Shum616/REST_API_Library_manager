package com.restapi.rest_api_lab2.service.implementations;

import com.restapi.rest_api_lab2.exeption.BookNotFoundEx;
import com.restapi.rest_api_lab2.persistance.entities.Book;
import com.restapi.rest_api_lab2.persistance.repositories.BookRepository;
import com.restapi.rest_api_lab2.service.interfaces.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository repository;
    private final Logger logger = LoggerFactory.getLogger(BookServiceImp.class);

    @Autowired
    public BookServiceImp(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public Book findBookById(long id) {
        logger.info("findTBookById {}", id);
        logger.info("isPresent {}", repository.findById(id).isPresent());
        return repository.findById(id).orElseThrow(() -> new BookNotFoundEx(id));
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findBookByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }
}
