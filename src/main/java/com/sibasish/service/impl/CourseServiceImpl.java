package com.sibasish.service.impl;

import com.sibasish.dto.CourseDTO;
import com.sibasish.entity.Course;
import com.sibasish.repository.CourseRepository;
import com.sibasish.response.CourseResponse;
import com.sibasish.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sibasish.util.CourseUtil.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseDTO courseDTO) {
        Course course = courseRepository.save(dtoToEntity(courseDTO));
        return entityToResponse(course);
    }
}
