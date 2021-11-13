package com.sibasish.service.impl;

import com.sibasish.dto.CourseDTO;
import com.sibasish.entity.Course;
import com.sibasish.exceptions.ResourceNotFoundException;
import com.sibasish.repository.CourseRepository;
import com.sibasish.response.CourseResponse;
import com.sibasish.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sibasish.util.CourseUtil.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseDTO courseDTO) {
        return entityToResponse(courseRepository.save(dtoToEntity(courseDTO)));
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            return entityToResponse(course);
        } else {
            throw new ResourceNotFoundException("Course not found for id: " + courseId);
        }
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseResponse> courseResponseList = new ArrayList<>();

        courseList.stream().forEach(course -> courseResponseList.add(entityToResponse(course)));

        return courseResponseList;
    }


}
