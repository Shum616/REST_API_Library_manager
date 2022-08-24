package com.restapi.rest_api_lab2.service.interfaces;

import com.restapi.rest_api_lab2.persistance.entities.BookSubscription;

import java.util.List;

public interface BookSubscriptionService {
    BookSubscription saveBookSubscription(BookSubscription bookSubscription);

    BookSubscription findBookSubscriptionById(long id);

    List<BookSubscription> findBookSubscriptionByBookId(long bookId);

    List<BookSubscription> findBookSubscriptionBySubscriptionId(long subscriptionId);

    void deleteBookSubscriptionById(long id);

    List<BookSubscription> getAll();
}
