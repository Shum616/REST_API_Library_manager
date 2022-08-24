package com.restapi.rest_api_lab2.persistance.repositories;
import com.restapi.rest_api_lab2.persistance.entities.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrarianRepository extends JpaRepository <Librarian, Long> {
    List<Librarian> findAllByName(String name);
}
