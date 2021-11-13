package com.sibasish.dto;

import com.sibasish.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    @NotBlank(message = "Course Name Cannot Be Blank")
    private String name;

    @Range(min = 1, max = 40, message = "Please enter a valid course credit b/w 1 & 40")
    private Integer credits;

    private Set<Student> studentSet;
}
