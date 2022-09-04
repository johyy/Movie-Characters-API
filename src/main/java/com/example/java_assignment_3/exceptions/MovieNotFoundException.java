package com.example.java_assignment_3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException  {
    public MovieNotFoundException (int id) {
        super("Movie does not exist with ID: " + id);
    }
}
