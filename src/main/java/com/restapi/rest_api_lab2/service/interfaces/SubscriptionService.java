package com.restapi.rest_api_lab2.service.interfaces;

import com.restapi.rest_api_lab2.persistance.entities.ReadingRoom;
import com.restapi.rest_api_lab2.persistance.entities.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription saveSubscription(Subscription subscription);

    Subscription findSubscriptionById(long id);

    List<Subscription> findSubscriptionByReaderId(long readerId);

    List<Subscription> findSubscriptionByLibrarianId(long librarianId);

    void deleteSubscriptionById(long id);

    List<Subscription> getAll();
}
