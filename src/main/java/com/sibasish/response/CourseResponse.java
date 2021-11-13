package com.sibasish.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sibasish.entity.Student;

import java.util.Set;

public class CourseResponse {

    private Long courseId;
    private String name;
    private Integer credits;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Student> studentSet;
}
