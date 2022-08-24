package com.restapi.rest_api_lab2.persistance.repositories;

import com.restapi.rest_api_lab2.persistance.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    List<Reader> findAllByName(String name);
}
