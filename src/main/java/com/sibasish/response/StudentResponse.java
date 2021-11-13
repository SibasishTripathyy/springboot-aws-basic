package com.sibasish.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sibasish.entity.Course;

import java.util.Set;

public class StudentResponse {

    private Long studentId;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Course> courseSet;
}
