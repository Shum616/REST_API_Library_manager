package com.restapi.rest_api_lab2.persistance.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor

public class Book extends BaseEntity{
    private String name;
    private String author;
    private String publisher;
    private LocalDate dateOfPublishing;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ReadingRoom> readingRoomList;
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<BookSubscription> bookSubscriptionList;

    public Book(String name, String author, String publisher, LocalDate dateOfPublishing){
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.dateOfPublishing = dateOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(dateOfPublishing, book.dateOfPublishing) && Objects.equals(publisher, book.publisher) && CollectionUtils.isEqualCollection(new ArrayList<>(readingRoomList), new ArrayList<>(book.readingRoomList)) && CollectionUtils.isEqualCollection(new ArrayList<>(bookSubscriptionList), new ArrayList<>(book.bookSubscriptionList));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, author, dateOfPublishing, publisher);
    }
}
