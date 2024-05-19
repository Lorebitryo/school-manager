package com.cyberways.schoolmanager.service;

import com.cyberways.schoolmanager.model.Student;
import com.cyberways.schoolmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public String updateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());

        optionalStudent.ifPresent(existingStudent -> {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            studentRepository.save(existingStudent);
        });

        return optionalStudent.map(Student::toString).orElse("Student not found");
    }

    public Optional<Student> deleteStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        optionalStudent.ifPresent(student -> studentRepository.deleteById(id));
        return optionalStudent;
    }
}
