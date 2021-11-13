package com.sibasish.service.impl;

import com.sibasish.dto.StudentDTO;
import com.sibasish.entity.Student;
import com.sibasish.exceptions.ResourceNotFoundException;
import com.sibasish.repository.StudentRepository;
import com.sibasish.response.StudentResponse;
import com.sibasish.service.StudentService;
import com.sibasish.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sibasish.util.StudentUtil.dtoToEntity;
import static com.sibasish.util.StudentUtil.entityToResponse;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentDTO studentDTO) {
        return entityToResponse(studentRepository.save(dtoToEntity(studentDTO)));
    }

    @Override
    public StudentResponse getStudentById(Long studentId) {

        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return entityToResponse(student);
        } else {
            throw new ResourceNotFoundException("Student not found for id: " + studentId);
        }
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(entityToResponse(student)));

        return studentResponseList;
    }
}
