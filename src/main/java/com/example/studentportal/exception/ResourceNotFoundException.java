package com.example.studentportal.exception;

// This is a custom exception that will be thrown when a requested resource (like a student) is not found.
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
