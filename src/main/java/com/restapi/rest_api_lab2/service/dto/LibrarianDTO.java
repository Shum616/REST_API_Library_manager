package com.restapi.rest_api_lab2.service.dto;

import com.restapi.rest_api_lab2.persistance.entities.Librarian;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LibrarianDTO {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String phone;

    public LibrarianDTO(Librarian librarian) {
        this.id = librarian.getId();
        this.name = librarian.getName();
        this.surname = librarian.getSurname();
        this.birthday = librarian.getBirthday();
        this.phone = librarian.getPhone();
    }
}
