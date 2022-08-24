package com.restapi.rest_api_lab2.service.interfaces;

import com.restapi.rest_api_lab2.persistance.entities.Librarian;

import java.util.List;

public interface LibrarianService {
    Librarian findLibrarianById(long id);

    List<Librarian> getAll();

    List<Librarian> findLibrarianByName(String name);

    Librarian saveLibrarian(Librarian librarian);

    void deleteLibrarianById(Long id);
}
