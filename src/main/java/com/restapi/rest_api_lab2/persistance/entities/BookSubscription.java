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
public class BookSubscription extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="subscription_id", nullable=false)
    private Subscription subscription;
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookSubscription bookSubscription = (BookSubscription) o;
        return Objects.equals(subscription, bookSubscription.subscription) && Objects.equals(book, bookSubscription.book);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
