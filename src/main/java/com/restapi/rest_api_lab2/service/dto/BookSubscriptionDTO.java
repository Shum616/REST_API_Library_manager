package com.restapi.rest_api_lab2.service.dto;

import com.restapi.rest_api_lab2.persistance.entities.BookSubscription;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookSubscriptionDTO {
    private long id;
    private long subscriptionId;
    private long bookId;

    public BookSubscriptionDTO(BookSubscription bookInSubscription){
        this.id = bookInSubscription.getId();
        this.subscriptionId = bookInSubscription.getSubscription().getId();
        this.bookId = bookInSubscription.getBook().getId();
    }
}
