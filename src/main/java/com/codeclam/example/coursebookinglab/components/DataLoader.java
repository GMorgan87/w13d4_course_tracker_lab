package com.codeclam.example.coursebookinglab.components;


import com.codeclam.example.coursebookinglab.models.Booking;
import com.codeclam.example.coursebookinglab.models.Course;
import com.codeclam.example.coursebookinglab.models.Customer;
import com.codeclam.example.coursebookinglab.repositories.BookingRepository;
import com.codeclam.example.coursebookinglab.repositories.CourseRepository;
import com.codeclam.example.coursebookinglab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        bookingRepository.deleteAll();
        courseRepository.deleteAll();
        customerRepository.deleteAll();

        Course softwareDevelopment = new Course("Software Development", "Edinburgh", 5);
        courseRepository.save(softwareDevelopment);
        Course dataAnalysis = new Course("Data Analysis", "Edinburgh", 3);
        courseRepository.save(dataAnalysis);

        Customer alan = new Customer("Alan", "Edinburgh", 38);
        customerRepository.save(alan);
        Customer gareth = new Customer("Gareth", "Edinburgh", 33);
        customerRepository.save(gareth);

        Booking booking1 = new Booking("13-01-20", alan, softwareDevelopment);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("15-01-20", gareth, dataAnalysis);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("20-01-20", gareth, softwareDevelopment);
        bookingRepository.save(booking3);

    }
}
