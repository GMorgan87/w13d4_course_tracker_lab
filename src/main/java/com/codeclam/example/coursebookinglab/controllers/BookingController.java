package com.codeclam.example.coursebookinglab.controllers;

import com.codeclam.example.coursebookinglab.models.Booking;
import com.codeclam.example.coursebookinglab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/bookings")
public class BookingController {

    @Autowired
    BookingRepository  bookingRepository;

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings(@RequestParam(name="date", required = false) String date) {
        if (date != null){
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
