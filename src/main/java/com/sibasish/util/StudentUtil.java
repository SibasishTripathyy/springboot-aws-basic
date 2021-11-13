package com.sibasish.util;

import com.sibasish.dto.StudentDTO;
import com.sibasish.entity.Student;
import com.sibasish.response.StudentResponse;

public class StudentUtil {

    public static Student dtoToEntity(StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setCourseSet(studentDTO.getCourseSet());
        return student;
    }

    public static StudentResponse entityToResponse(Student student) {

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setStudentId(student.getStudentId());
        studentResponse.setName(student.getName());
        studentResponse.setCourseSet(student.getCourseSet());

        return studentResponse;
    }
}
