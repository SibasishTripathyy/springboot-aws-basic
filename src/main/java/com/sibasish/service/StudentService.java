package com.sibasish.service;

import com.sibasish.dto.StudentDTO;
import com.sibasish.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentDTO studentDTO);

    StudentResponse getStudentById(Long studentId);

    List<StudentResponse> getAllStudents();
}
