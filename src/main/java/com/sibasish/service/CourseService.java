package com.sibasish.service;

import com.sibasish.dto.CourseDTO;
import com.sibasish.response.CourseResponse;

public interface CourseService {

    CourseResponse createCourse(CourseDTO courseDTO);
}
