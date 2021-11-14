package com.sibasish.controller;

import com.sibasish.dto.CourseDTO;
import com.sibasish.response.CourseResponse;
import com.sibasish.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * API for creating a new course in the DB
     *
     * @param courseDTO - the course input data
     * @return the newly created course's response
     */
    @PostMapping("/create")
    public ResponseEntity<CourseResponse> createCourse(@RequestBody @Valid CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.createCourse(courseDTO), HttpStatus.CREATED);
    }


    /**
     * API to fetch a course by its id
     *
     * @param courseId - the required course id
     * @return the required course by its id
     */
    @GetMapping("/getCourseById/{courseId}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable("courseId") Long courseId) {
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }


    /**
     * API to fetch all courses
     *
     * @return a list of all courses
     */
    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }
}
