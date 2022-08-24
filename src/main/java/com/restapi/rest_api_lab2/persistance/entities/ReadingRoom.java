package com.restapi.rest_api_lab2.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReadingRoom extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="reader_id", nullable=false)
    private Reader reader;
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReadingRoom readingRoom = (ReadingRoom) o;
        return Objects.equals(reader, readingRoom.reader) && Objects.equals(book, readingRoom.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
