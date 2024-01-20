package com.bookmyshow.BookMyShow.repositories;

import com.bookmyshow.BookMyShow.entites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserId(Long userId);
}
