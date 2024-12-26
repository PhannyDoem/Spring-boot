package com.student.service;

import com.student.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    Optional<Teacher> getTeacherById(Long id);

    List<Teacher> getAllTeachers();

    Teacher updateTeacher(long id, Teacher teacher);

    String deleteTeacher(long id);
}
