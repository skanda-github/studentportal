package com.example.studentportal.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Student {

    @NotEmpty(message = "{student.name.empty}")
    @Size(min = 3, max = 50, message = "{student.name.size}")
    private String name;

    @Min(value = 18, message = "{student.age.min}")
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
