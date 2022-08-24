package com.restapi.rest_api_lab2.service.implementations;

import com.restapi.rest_api_lab2.exeption.ReaderNotFoundEx;
import com.restapi.rest_api_lab2.persistance.entities.Reader;
import com.restapi.rest_api_lab2.persistance.repositories.ReaderRepository;
import com.restapi.rest_api_lab2.service.interfaces.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImp implements ReaderService {

    private final ReaderRepository repository;
    private final Logger logger = LoggerFactory.getLogger(ReaderServiceImp.class);

    @Autowired
    public ReaderServiceImp(ReaderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reader findReaderById(long id) {
        logger.info("findReaderById {}", id);
        logger.info("isPresent {}", repository.findById(id).isPresent());
        return repository.findById(id).orElseThrow(() -> new ReaderNotFoundEx(id));
    }

    @Override
    public List<Reader> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Reader> findReaderByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Reader saveReader(Reader reader) {
        return repository.save(reader);
    }

    @Override
    public void deleteReaderById(Long id) {
        repository.deleteById(id);
    }
}
