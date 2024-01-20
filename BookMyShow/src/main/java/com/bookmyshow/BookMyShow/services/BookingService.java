package com.bookmyshow.BookMyShow.services;

import com.bookmyshow.BookMyShow.entites.Booking;

import java.util.List;

public interface BookingService {
    public List<Booking> getUserBookings(Long userId);
    public Booking bookTicket(Long userId,Long movieId,int seats);
}
