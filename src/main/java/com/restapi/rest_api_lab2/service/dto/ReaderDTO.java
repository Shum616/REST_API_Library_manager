package com.restapi.rest_api_lab2.service.dto;

import com.restapi.rest_api_lab2.persistance.entities.Reader;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReaderDTO {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String phone;

    public ReaderDTO(Reader reader) {
        this.id = reader.getId();
        this.name = reader.getName();
        this.surname = reader.getSurname();
        this.birthday = reader.getBirthday();
        this.phone = reader.getPhone();
    }
}
