package com.restapi.rest_api_lab2.exeption;

public class SubscriptionNotFoundEx extends RuntimeException{
    public SubscriptionNotFoundEx(Long id) {
        super("Could not find subscription for id: " + id);
    }
}
