package com.restapi.rest_api_lab2.service.implementations;

import com.restapi.rest_api_lab2.exeption.LibrarianNotFoundEx;
import com.restapi.rest_api_lab2.persistance.entities.Librarian;
import com.restapi.rest_api_lab2.persistance.repositories.LibrarianRepository;
import com.restapi.rest_api_lab2.service.interfaces.LibrarianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianServiceImp implements LibrarianService {

    private final LibrarianRepository repository;
    private final Logger logger = LoggerFactory.getLogger(LibrarianServiceImp.class);

    @Autowired
    public LibrarianServiceImp(LibrarianRepository repository) {
        this.repository = repository;
    }

    @Override
    public Librarian findLibrarianById(long id) {
        logger.info("findLibrarianById {}", id);
        logger.info("isPresent {}", repository.findById(id).isPresent());
        return repository.findById(id).orElseThrow(() -> new LibrarianNotFoundEx(id));
    }

    @Override
    public List<Librarian> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Librarian> findLibrarianByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Librarian saveLibrarian(Librarian librarian) {
        return repository.save(librarian);
    }

    @Override
    public void deleteLibrarianById(Long id) {
        repository.deleteById(id);
    }
}
