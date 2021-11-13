package com.sibasish.dto;

import com.sibasish.entity.Student;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CourseDTO {

    @NotBlank(message = "Course Name Cannot Be Blank")
    private String name;

    @NotBlank(message = "Please enter course credits")
    private Integer credits;

    private Set<Student> studentSet;
}
