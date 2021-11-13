package com.sibasish.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
