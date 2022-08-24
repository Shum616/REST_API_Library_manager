package com.restapi.rest_api_lab2.service.dto;

import com.restapi.rest_api_lab2.persistance.entities.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookDTO {
    private long id;
    private String name;
    private String author;
    private LocalDate dateOfPublication;
    private String publisher;

    public BookDTO(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.dateOfPublication = book.getDateOfPublishing();
        this.publisher = book.getPublisher();
    }
}
