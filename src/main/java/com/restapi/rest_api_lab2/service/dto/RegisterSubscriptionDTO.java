package com.restapi.rest_api_lab2.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class RegisterSubscriptionDTO {
    private long readerId;
    private long librarianId;
    private LocalDate wasGiven;
    private LocalDate willBeTaken;
}
