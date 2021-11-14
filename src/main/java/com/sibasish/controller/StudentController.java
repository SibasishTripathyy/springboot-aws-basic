package com.sibasish.controller;

import com.sibasish.dto.StudentDTO;
import com.sibasish.response.StudentResponse;
import com.sibasish.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * API to create a new student
     *
     * @param studentDTO - the student input data
     * @return the newly created student's response
     */
    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }

    /**
     * API to fetch a student by its id
     *
     * @param studentId - the required student's id
     * @return the student by its id
     */
    @GetMapping("getStudentById/{studentId}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    /**
     * API to fetch all the students
     *
     * @return a list of all the students
     */
    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
