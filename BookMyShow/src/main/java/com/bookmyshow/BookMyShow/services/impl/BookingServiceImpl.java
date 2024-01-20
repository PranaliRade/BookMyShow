package com.bookmyshow.BookMyShow.services.impl;

import com.bookmyshow.BookMyShow.entites.Booking;
import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.entites.User;
import com.bookmyshow.BookMyShow.repositories.BookingRepository;
import com.bookmyshow.BookMyShow.repositories.MovieRepository;
import com.bookmyshow.BookMyShow.repositories.UserRepository;
import com.bookmyshow.BookMyShow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return null;
    }

    @Override
    public Booking bookTicket(Long userId, Long movieId, int seats) {
        // Validate user and movie existence
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movies movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // Validate available seats
        if (isSeatsAvailable(movie, seats)) {
            // Update available seats in the movie entity
            movie.setAvailableSeats(movie.getAvailableSeats() - seats);
            movieRepository.save(movie);

            // Save booking
            Booking booking = new Booking();
            booking.setUserId(userId);
            booking.setMovieId(movieId);
            booking.setBookingDate(LocalDateTime.now());
            booking.setSeats(seats);

            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Not enough available seats");
        }
    }
}
