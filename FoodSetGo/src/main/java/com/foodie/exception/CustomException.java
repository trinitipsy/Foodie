package com.foodie.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    public CustomException(String message, HttpStatus httpStatus) {

    }
}
