package com.restapi.rest_api_lab2.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RegisterReadingRoomDTO {
    private long readerId;
    private long bookId;
}
