package com.restapi.rest_api_lab2.service.interfaces;

import com.restapi.rest_api_lab2.persistance.entities.Reader;

import java.util.List;

public interface ReaderService {
    Reader findReaderById(long id);

    List<Reader> getAll();

    List<Reader> findReaderByName(String name);

    Reader saveReader(Reader reader);

    void deleteReaderById(Long id);
}
