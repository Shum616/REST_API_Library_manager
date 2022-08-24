package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.exeption.BookNotFoundEx;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookNotFoundAdv {
    @ResponseBody
    @ExceptionHandler(BookNotFoundEx.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentNotFoundHandler(BookNotFoundEx e){
        return e.getMessage();
    }
}
