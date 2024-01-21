package com.bookmyshow.BookMyShow.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int foodItemId;

    private String itemName;
    private String price;
    @OneToMany(mappedBy = "foodItem")
    private List<Booking> bookings;


}
