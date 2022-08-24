package com.restapi.rest_api_lab2.service.dto;
import com.restapi.rest_api_lab2.persistance.entities.ReadingRoom;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadingRoomDTO {
    private long id;
    private long readerId;
    private long bookId;

    public ReadingRoomDTO(ReadingRoom readingRoom) {
        this.id = readingRoom.getId();
        this.readerId = readingRoom.getReader().getId();
        this.bookId = readingRoom.getBook().getId();
    }
}
