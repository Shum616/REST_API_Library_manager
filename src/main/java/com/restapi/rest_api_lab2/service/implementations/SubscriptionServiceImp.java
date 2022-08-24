package com.restapi.rest_api_lab2.service.implementations;

import com.restapi.rest_api_lab2.exeption.SubscriptionNotFoundEx;
import com.restapi.rest_api_lab2.persistance.entities.Subscription;
import com.restapi.rest_api_lab2.persistance.repositories.SubscriptionRepository;
import com.restapi.rest_api_lab2.service.interfaces.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    private final SubscriptionRepository repository;
    private final Logger logger = LoggerFactory.getLogger(SubscriptionServiceImp.class);

    @Autowired
    public SubscriptionServiceImp(SubscriptionRepository repository) {
        this.repository = repository;
    }


    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public Subscription findSubscriptionById(long id) {
        logger.info("findSubscriptionById {}", id);
        logger.info("isPresent {}", repository.findById(id).isPresent());
        return repository.findById(id).orElseThrow(() -> new SubscriptionNotFoundEx(id));
    }

    @Override
    public List<Subscription> findSubscriptionByReaderId(long readerId) {
        return repository.findAllByReaderId(readerId);
    }

    @Override
    public List<Subscription> findSubscriptionByLibrarianId(long librarianId) {
        return repository.findAllByLibrarianId(librarianId);
    }

    @Override
    public void deleteSubscriptionById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Subscription> getAll() {
        logger.info("getAll");
        return repository.findAll();
    }
}
