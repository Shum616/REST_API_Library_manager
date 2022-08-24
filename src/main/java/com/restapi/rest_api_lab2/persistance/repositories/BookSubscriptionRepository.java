package com.restapi.rest_api_lab2.persistance.repositories;


import com.restapi.rest_api_lab2.persistance.entities.BookSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookSubscriptionRepository extends JpaRepository<BookSubscription, Long> {
    List<BookSubscription> findAllBySubscriptionId(Long id);
    List<BookSubscription> findAllByBookId(Long id);
}
