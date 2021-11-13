package com.sibasish.service;

import com.sibasish.dto.CourseDTO;
import com.sibasish.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CourseDTO courseDTO);

    CourseResponse getCourseById(Long courseId);

    List<CourseResponse> getAllCourses();
}
