package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.exeption.SubscriptionNotFoundEx;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SubscriptionNotFoundAdv {
    @ResponseBody
    @ExceptionHandler(SubscriptionNotFoundEx.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String subscriptionNotFoundHandler(SubscriptionNotFoundEx e){
        return e.getMessage();
    }
}
