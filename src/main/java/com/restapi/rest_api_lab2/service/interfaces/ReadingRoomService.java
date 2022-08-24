package com.restapi.rest_api_lab2.service.interfaces;

import com.restapi.rest_api_lab2.persistance.entities.BookSubscription;
import com.restapi.rest_api_lab2.persistance.entities.ReadingRoom;

import java.util.List;

public interface ReadingRoomService {
    ReadingRoom saveReadingRoom(ReadingRoom readingRoom);

    ReadingRoom findReadingRoomById(long id);

    List<ReadingRoom> findReadingRoomByReaderId(long readerId);

    List<ReadingRoom> findReadingRoomByBookId(long bookId);

    void deleteReadingRoomById(long id);

    List<ReadingRoom> getAll();
}
