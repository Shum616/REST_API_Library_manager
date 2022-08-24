package com.restapi.rest_api_lab2.persistance.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Librarian extends BaseEntity{
    private String name;
    private String surname;
    private LocalDate birthday;
    private String phone;
    @OneToMany(mappedBy = "librarian", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Subscription> bookSubscriptionList;

    public Librarian(String name, String surname, LocalDate birthday, String phone) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(name, librarian.name) && Objects.equals(surname, librarian.surname) && Objects.equals(birthday, librarian.birthday) && Objects.equals(phone, librarian.phone) && CollectionUtils.isEqualCollection(new ArrayList<>(bookSubscriptionList), new ArrayList<>(librarian.bookSubscriptionList));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, birthday, phone);
    }
}
