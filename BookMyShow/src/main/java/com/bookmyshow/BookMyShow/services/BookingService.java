package com.bookmyshow.BookMyShow.services;

import com.bookmyshow.BookMyShow.entites.Booking;
import com.bookmyshow.BookMyShow.payloads.BookingDto;
import com.bookmyshow.BookMyShow.payloads.FoodItemDto;
import com.bookmyshow.BookMyShow.payloads.MovieDto;
import com.bookmyshow.BookMyShow.payloads.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {
    public List<Booking> getUserBookings(Long userId);
    public ResponseEntity<String> bookMovieTicket(BookingDto bookingDto);
}
