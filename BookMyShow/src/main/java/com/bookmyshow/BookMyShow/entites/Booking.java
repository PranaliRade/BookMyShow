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
    private String location;
    private String theater;
    @ElementCollection
    @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat")
    private List<String> bookedSeats;

    private LocalDateTime BookingDate;
    private Double totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;
 @ManyToOne
 private FoodItem foodItem;

}
