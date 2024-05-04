package com.cyberways.schoolmanager.service;

import com.cyberways.schoolmanager.model.Student;
import com.cyberways.schoolmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public String createStudent(Student student) {
        return studentRepository.save(student).toString();
    }
}
