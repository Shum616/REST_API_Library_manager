package com.restapi.rest_api_lab2.exeption;

public class BookNotFoundEx extends RuntimeException{
    public BookNotFoundEx(Long id) {
        super("Could not find book for id: " + id);
    }
}
