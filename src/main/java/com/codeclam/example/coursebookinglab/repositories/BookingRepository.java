package com.codeclam.example.coursebookinglab.repositories;

import com.codeclam.example.coursebookinglab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(String date);

}
