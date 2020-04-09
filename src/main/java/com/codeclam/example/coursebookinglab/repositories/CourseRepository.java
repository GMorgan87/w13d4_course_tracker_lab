package com.codeclam.example.coursebookinglab.repositories;

import com.codeclam.example.coursebookinglab.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(Integer rating);
    List<Course> findCoursesByBookingsCustomerId(Long customer_id);

}
