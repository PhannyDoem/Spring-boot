package com.student.service;

import com.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    Optional<Student> getStudentById(Long id);

    List<Student> getAllStudents();

    Student updateStudent(long id, Student student);

    String deleteStudent(long id);
}
