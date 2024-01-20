package com.bookmyshow.BookMyShow.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String userName;
    private String userEmail;
    private String movieName;
    private String poster;
    private String location;
    private String theater;
    @ElementCollection
    @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat")
    private List<String> bookedSeats;

    private String time;
    private String food;
    private String price;
    private Double totalPrice;
}
