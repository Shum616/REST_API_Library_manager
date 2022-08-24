package com.restapi.rest_api_lab2.service.implementations;

import com.restapi.rest_api_lab2.exeption.ReadingRoomNotFoundEx;
import com.restapi.rest_api_lab2.persistance.entities.ReadingRoom;
import com.restapi.rest_api_lab2.persistance.repositories.ReadingRoomRepository;
import com.restapi.rest_api_lab2.service.interfaces.ReadingRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingRoomServiceImp implements ReadingRoomService {

    private final ReadingRoomRepository repository;
    private final Logger logger = LoggerFactory.getLogger(ReadingRoomServiceImp.class);

    @Autowired
    public ReadingRoomServiceImp(ReadingRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReadingRoom saveReadingRoom(ReadingRoom readingRoom) {
        return repository.save(readingRoom);
    }

    @Override
    public ReadingRoom findReadingRoomById(long id) {
        logger.info("findReadingRoomById {}", id);
        logger.info("isPresent {}", repository.findById(id).isPresent());
        return repository.findById(id).orElseThrow(() -> new ReadingRoomNotFoundEx(id));
    }

    @Override
    public List<ReadingRoom> findReadingRoomByReaderId(long readerId) {
        return repository.findAllByReaderId(readerId);
    }

    @Override
    public List<ReadingRoom> findReadingRoomByBookId(long bookId) {
        return repository.findAllByBookId(bookId);
    }

    @Override
    public void deleteReadingRoomById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReadingRoom> getAll() {
        return repository.findAll();
    }
}
