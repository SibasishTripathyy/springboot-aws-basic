package com.sibasish.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sibasish.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private Long courseId;
    private String name;
    private Integer credits;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Student> studentSet;
}
