package com.cyberways.schoolmanager.service;

import com.cyberways.schoolmanager.model.Course;
import com.cyberways.schoolmanager.model.Student;
import com.cyberways.schoolmanager.repository.CourseRepository;
import com.cyberways.schoolmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

//    public List<Student> searchByFirstName(String firstNamePart) {
//        return studentRepository.findByFirstNameContainingIgnoreCase(firstNamePart);
//    }
//
//    public Student createStudent(Student student) {
//        return studentRepository.save(student);
//    }
//
//    public Optional<Student> updateStudent(Long id, Student student) {
//
//        return studentRepository.findById(id).map(existingStudent -> {
//            existingStudent.setFirstName(student.getFirstName());
//            existingStudent.setLastName(student.getLastName());
//            return studentRepository.save(existingStudent);
//        });
//    }
//
//    public boolean deleteStudentById(Long id) {
//
//        return studentRepository.findById(id).map(student -> {
//            studentRepository.deleteById(id);
//            return true;
//        }).orElse(false);
//    }
}
