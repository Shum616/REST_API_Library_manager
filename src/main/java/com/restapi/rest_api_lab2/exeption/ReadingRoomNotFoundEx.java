package com.restapi.rest_api_lab2.exeption;

public class ReadingRoomNotFoundEx extends RuntimeException{
    public ReadingRoomNotFoundEx(Long id) {
        super("Could not find reading room for id: " + id);
    }
}
