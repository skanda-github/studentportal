package com.example.studentportal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // A global exception handler.
public class GlobalExceptionHandler {

    // Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Catches specific exceptions and returns custom responses.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException exception){
        logger.warn(exception.getMessage());
        return new ResponseEntity<>("Error : " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception exception) {
        logger.error("Unexpected error occurred", exception);
        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
