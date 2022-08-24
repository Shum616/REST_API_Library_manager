package com.restapi.rest_api_lab2.service.implementations;

import com.restapi.rest_api_lab2.exeption.BookSubscriptionNotFoundEx;
import com.restapi.rest_api_lab2.persistance.entities.BookSubscription;
import com.restapi.rest_api_lab2.persistance.repositories.BookSubscriptionRepository;
import com.restapi.rest_api_lab2.service.interfaces.BookSubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSubscriptionServiceImp implements BookSubscriptionService {

    private final BookSubscriptionRepository repository;
    private final Logger logger = LoggerFactory.getLogger(BookSubscriptionServiceImp.class);

    @Autowired
    public BookSubscriptionServiceImp(BookSubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookSubscription saveBookSubscription(BookSubscription bookSubscription) {
        return repository.save(bookSubscription);
    }

    @Override
    public BookSubscription findBookSubscriptionById(long id) {
        logger.info("findBookSubscriptionById {}", id);
        logger.info("isPresent {}", repository.findById(id).isPresent());
        return repository.findById(id).orElseThrow(() -> new BookSubscriptionNotFoundEx(id));
    }

    @Override
    public List<BookSubscription> findBookSubscriptionByBookId(long bookId) {
        return repository.findAllByBookId(bookId);
    }

    @Override
    public List<BookSubscription> findBookSubscriptionBySubscriptionId(long subscriptionId) {
        return repository.findAllBySubscriptionId(subscriptionId);
    }

    @Override
    public void deleteBookSubscriptionById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BookSubscription> getAll() {
        return repository.findAll();
    }
}
