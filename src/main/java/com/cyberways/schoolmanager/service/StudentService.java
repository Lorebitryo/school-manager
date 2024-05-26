package com.cyberways.schoolmanager.service;

import com.cyberways.schoolmanager.model.Student;
import com.cyberways.schoolmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student student) {

        return studentRepository.findById(id).map(existingStudent -> {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            return studentRepository.save(existingStudent);
        });
    }

    public boolean deleteStudentById(Long id) {

        return studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
