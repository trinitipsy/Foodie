package com.foodie.exception;

import com.foodie.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadLogin(RuntimeException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(getErrorMessage(ex));
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(getErrorMessage(ex));
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private String getErrorMessage(Exception e) {
        String errorMessage;

        if (e instanceof NotFoundException) {
            errorMessage = "Not Found";
        } else {
            errorMessage = "Internal Server Error";
        }

        return errorMessage;
    }

}
