package com.restapi.rest_api_lab2.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subscription extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="reader_id", nullable=false)
    private Reader reader;
    @ManyToOne
    @JoinColumn(name="librarian_id", nullable=false)
    private Librarian librarian;


    private LocalDate wasGiven;
    private LocalDate willBeTaken;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subscription subscription = (Subscription) o;
        return Objects.equals(wasGiven, subscription.wasGiven) && Objects.equals(willBeTaken, subscription.willBeTaken) && Objects.equals(librarian, subscription.librarian)&& Objects.equals(reader, subscription.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wasGiven, willBeTaken);
    }
}
