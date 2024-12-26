package com.student.controller;

import com.student.model.Teacher;
import com.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id){
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/teachers")
    public ResponseEntity<Iterable<Teacher>> getAllTeachers(){
        Iterable<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacherDetails){
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacherDetails);
        return updatedTeacher != null ? new ResponseEntity<>(updatedTeacher, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        String response = teacherService.deleteTeacher(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
