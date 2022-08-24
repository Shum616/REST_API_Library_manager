package com.restapi.rest_api_lab2.exeption;

public class LibrarianNotFoundEx extends RuntimeException{
    public LibrarianNotFoundEx(Long id) {
        super("Could not find librarian for id: " + id);
    }
}
