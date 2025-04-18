package com.example.studentportal.controller;

import com.example.studentportal.exception.ResourceNotFoundException;
import com.example.studentportal.model.Student;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    // ✅ POST: Add new student with validation
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody @Valid Student student, BindingResult result) {
        logger.info("Request received to add student: {}", student.getName());

        if (result.hasErrors()) {
            logger.error("Validation failed for student: {} | Errors: {}", student, result.getAllErrors());
            return new ResponseEntity<>("Validation failed. Please check the input data.", HttpStatus.BAD_REQUEST);
        }

        logger.info("Student added successfully: {}", student.getName());
        return new ResponseEntity<>("Student added successfully!", HttpStatus.CREATED);
    }

    // ✅ GET: Fetch student by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getStudent(@PathVariable int id) {
        logger.info("Request received to fetch student with ID: {}", id);

        if (id != 1) {
            logger.warn("Student with ID {} not found.", id);
            throw new ResourceNotFoundException("ResourceNotFoundException - Student with ID " + id + " not found.");
        }

        logger.info("Student with ID {} found.", id);
        return new ResponseEntity<>("Student found!", HttpStatus.OK);
    }

    // ✅ NEW: Simulate a general exception (500 error)
    @GetMapping("/test-error")
    public String triggerError() {
        logger.error("Simulated internal server error triggered.");
        throw new RuntimeException("RuntimeException - Simulated internal server error");
    }
}