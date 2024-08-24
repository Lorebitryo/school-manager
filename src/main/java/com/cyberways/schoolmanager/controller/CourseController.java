package com.cyberways.schoolmanager.controller;

import com.cyberways.schoolmanager.model.Course;
import com.cyberways.schoolmanager.model.Student;
import com.cyberways.schoolmanager.service.CourseService;
import com.cyberways.schoolmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {

        Optional<Course> course = courseService.getCourseById(id);

        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/searchByFirstName")
//    public ResponseEntity<List<Student>> searchByFirstName(@RequestParam String firstNamePart) {
//
//        List<Student> students = studentService.searchByFirstName(firstNamePart);
//
//        if(students.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(students);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        Student createdStudent = studentService.createStudent(student);
//        return ResponseEntity.ok(createdStudent);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        Optional<Student> updatedStudent = studentService.updateStudent(id, student);
//        return updatedStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
//        boolean isDeleted = studentService.deleteStudentById(id);
//
//        if(isDeleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
