package com.cyberways.schoolmanager.repository;

import com.cyberways.schoolmanager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

//    List<Student> findByFirstNameContainingIgnoreCase(String firstNamePart);

}
