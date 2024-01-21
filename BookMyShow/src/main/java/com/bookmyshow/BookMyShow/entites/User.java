package com.bookmyshow.BookMyShow.entites;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
}
