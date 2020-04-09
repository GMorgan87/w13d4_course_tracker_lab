package com.codeclam.example.coursebookinglab.controllers;

import com.codeclam.example.coursebookinglab.models.Customer;
import com.codeclam.example.coursebookinglab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(@RequestParam(name="course", required = false) Long course_id,
                                                      @RequestParam(name="town", required = false) String town,
                                                      @RequestParam(name="age", required = false) Integer age){
        if (course_id != null && town != null && age != null){
            return new ResponseEntity<>(customerRepository.findCustomersByAgeGreaterThanAndBookingsCourseIdAndTown(age, course_id, town), HttpStatus.OK);
        }
        if (course_id != null && town != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseIdAndTown(course_id, town), HttpStatus.OK);
        }
        if (course_id != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseId(course_id), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
