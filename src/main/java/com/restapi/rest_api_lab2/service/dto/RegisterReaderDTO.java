package com.restapi.rest_api_lab2.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class RegisterReaderDTO {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String phone;
}
