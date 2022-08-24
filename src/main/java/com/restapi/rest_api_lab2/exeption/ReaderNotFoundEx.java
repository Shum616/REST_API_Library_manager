package com.restapi.rest_api_lab2.exeption;

public class ReaderNotFoundEx extends RuntimeException{
    public ReaderNotFoundEx(Long id) {
        super("Could not find reader for id: " + id);
    }
}
