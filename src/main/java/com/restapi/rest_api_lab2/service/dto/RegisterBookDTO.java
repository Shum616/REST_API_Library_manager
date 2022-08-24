package com.restapi.rest_api_lab2.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterBookDTO {
    private String name;
    private String author;
    private LocalDate dateOfPublication;
    private String publisher;
}
