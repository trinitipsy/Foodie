package com.foodie.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final String message;
    private HttpStatus status;

    public CustomException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }

}
