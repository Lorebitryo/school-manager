package com.cyberways.schoolmanager.controller;

import com.cyberways.schoolmanager.model.Student;
import com.cyberways.schoolmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id).get().toString();
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/student")
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        return studentService.deleteStudentById(id).toString();
    }

}
