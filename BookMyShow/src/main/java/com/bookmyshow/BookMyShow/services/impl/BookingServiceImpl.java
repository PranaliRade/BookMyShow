package com.bookmyshow.BookMyShow.services.impl;

import com.bookmyshow.BookMyShow.entites.Booking;
import com.bookmyshow.BookMyShow.entites.FoodItem;
import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.entites.User;
import com.bookmyshow.BookMyShow.payloads.BookingDto;
import com.bookmyshow.BookMyShow.payloads.FoodItemDto;
import com.bookmyshow.BookMyShow.payloads.MovieDto;
import com.bookmyshow.BookMyShow.payloads.UserDto;
import com.bookmyshow.BookMyShow.repositories.BookingRepository;
import com.bookmyshow.BookMyShow.repositories.FoodItemRepository;
import com.bookmyshow.BookMyShow.repositories.MovieRepository;
import com.bookmyshow.BookMyShow.repositories.UserRepository;
import com.bookmyshow.BookMyShow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public ResponseEntity<String> bookMovieTicket(BookingDto bookingDto) {
        // Validate user, movie, and seat availability
        Movies user = userRepository.findByUsername(bookingDto.getUserDto().getUserName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movies movie = movieRepository.findByTitleContainingIgnoreCase(bookingDto.getMovieDto().getMovieName())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // Validate seat availability
        if (!areSeatsAvailable(movie, bookingDto.getBookedSeats())) {
            return ResponseEntity.badRequest().body("Not enough available seats");
        }

        // Create a Booking entity
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovie(movie);
        booking.setBookingDate(LocalDateTime.now());
        booking.setLocation(bookingDto.getLocation());
        booking.setTheater(bookingDto.getTheater());
      //  booking.setTime(bookingDto.getTime());
        booking.setBookedSeats(bookingDto.getBookedSeats());
        //booking.setPrice(bookingDto.getPrice());
        booking.setTotalPrice((double) bookingDto.getTotalPrice());

        // Save the booking
        Booking savedBooking = bookingRepository.save(booking);

        // Save food items associated with the booking
        List<FoodItem> foodItems = bookingDto.getFoodItems().stream()
                .map(foodItemDto -> {
                    FoodItem foodItem = new FoodItem();
                    foodItem.setItemName(foodItemDto.getItemName());
                    foodItem.setPrice(String.valueOf(foodItemDto.getPrice()));
                    foodItem.setBooking(savedBooking);
                    return foodItem;
                })
                .collect(Collectors.toList());

        foodItemRepository.saveAll(foodItems);

        // Update other entities or perform additional logic as needed

        return ResponseEntity.ok("Movie ticket booked successfully");
    }

    private boolean areSeatsAvailable(Movies movie, List<String> bookedSeats) {
        // Implement logic to check seat availability based on your requirements
        // You might want to check if the requested seats are available in the movie
        // and if the seats are not already booked for another showtime, etc.
        // For simplicity, let's assume all seats are available in this example.
        return true;
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return null;
    }


}