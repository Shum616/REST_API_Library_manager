package com.restapi.rest_api_lab2.persistance.repositories;

import com.restapi.rest_api_lab2.persistance.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findAllByReaderId(Long id);
    List<Subscription> findAllByLibrarianId(Long id);
}
