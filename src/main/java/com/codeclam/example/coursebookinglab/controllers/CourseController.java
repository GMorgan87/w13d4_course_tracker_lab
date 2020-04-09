package com.codeclam.example.coursebookinglab.controllers;

import com.codeclam.example.coursebookinglab.models.Course;
import com.codeclam.example.coursebookinglab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/courses")

public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(@RequestParam(name="rating", required=false) Integer rating,
                                                   @RequestParam(name="customer_id", required=false) Long customer_id){
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (customer_id != null){
            return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerId(customer_id), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
