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
public class Reader extends BaseEntity{
    private String name;
    private String surname;
    private LocalDate birthday;
    private String phone;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ReadingRoom> readingRoomList;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Subscription> subscriptionList;

    public Reader(String name, String surname, LocalDate birthday, String phone) {
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
        Reader reader = (Reader) o;
        return Objects.equals(name, reader.name) && Objects.equals(surname, reader.surname) && Objects.equals(birthday, reader.birthday) && Objects.equals(phone, reader.phone) && CollectionUtils.isEqualCollection(new ArrayList<>(readingRoomList), new ArrayList<>(reader.readingRoomList))
                && CollectionUtils.isEqualCollection(new ArrayList<>(subscriptionList), new ArrayList<>(reader.subscriptionList));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, birthday, phone);
    }
}
