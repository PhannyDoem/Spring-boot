package com.student.service.impl;

import com.student.model.Teacher;
import com.student.repository.TeacherRepository;
import com.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher updateTeacher(long id, Teacher teacher) {
        return teacherRepository.findById(id)
                .map(teacher1 -> {
                    teacher1.setFirstName(teacher.getFirstName());
                    teacher1.setLastName(teacher.getLastName());
                    teacher1.setEmail(teacher.getEmail());
                    teacher1.setDepartment(teacher.getDepartment());
                    return teacherRepository.save(teacher1);
                }).orElse( null);
    }

    @Override
    public String deleteTeacher(long id) {
        teacherRepository.deleteById(id);
        return "Teacher Deleted Successfully";
    }
}
