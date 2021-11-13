package com.sibasish.dto;

import com.sibasish.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotBlank(message = "Student Name Cannot Be Blank")
    private String name;

    @NotEmpty(message = "A student needs to be enrolled in at least one course")
    private Set<@Valid Course> courseSet;
}
