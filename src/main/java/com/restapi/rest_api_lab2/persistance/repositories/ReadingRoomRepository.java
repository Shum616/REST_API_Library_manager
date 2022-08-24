package com.restapi.rest_api_lab2.persistance.repositories;

import com.restapi.rest_api_lab2.persistance.entities.ReadingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingRoomRepository extends JpaRepository<ReadingRoom, Long> {
    List<ReadingRoom> findAllByReaderId(Long id);
    List<ReadingRoom> findAllByBookId(Long id);
}
