package com.restapi.rest_api_lab2.exeption;

public class BookSubscriptionNotFoundEx extends RuntimeException{
    public BookSubscriptionNotFoundEx(Long id) {
        super("Could not find book subscription for id: " + id);
    }
}
