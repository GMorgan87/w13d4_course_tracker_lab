package com.codeclam.example.coursebookinglab.repositories;

import com.codeclam.example.coursebookinglab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseId(Long course_id);

    List<Customer> findCustomersByBookingsCourseIdAndTown(Long course_id, String town);

    List<Customer> findCustomersByAgeGreaterThanAndBookingsCourseIdAndTown(Integer age, Long course_id, String town);

}
