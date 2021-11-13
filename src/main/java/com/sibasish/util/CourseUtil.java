package com.sibasish.util;

import com.sibasish.dto.CourseDTO;
import com.sibasish.entity.Course;
import com.sibasish.response.CourseResponse;

public class CourseUtil {

    public static Course dtoToEntity(CourseDTO courseDTO) {

        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setCredits(courseDTO.getCredits());

        if (courseDTO.getStudentSet() != null)
            course.setStudentSet(courseDTO.getStudentSet());

        return course;
    }

    public static CourseResponse entityToResponse(Course course) {

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseId(course.getCourseId());
        courseResponse.setName(course.getName());
        courseResponse.setCredits(course.getCredits());

        if (course.getStudentSet() != null)
            courseResponse.setStudentSet(course.getStudentSet());

        return courseResponse;
    }
}
