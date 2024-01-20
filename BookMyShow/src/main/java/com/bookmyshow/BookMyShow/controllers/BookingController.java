package com.bookmyshow.BookMyShow.controllers;

import com.bookmyshow.BookMyShow.entites.Booking;
import com.bookmyshow.BookMyShow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/book")
    public ResponseEntity<Booking> bookTicket(
            @RequestParam Long userId,
            @RequestParam Long movieId,
            @RequestParam int seats) {

        Booking booked = bookingService.bookTicket(userId, movieId, seats);
        return new ResponseEntity<>(booked, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getUserBookings(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
