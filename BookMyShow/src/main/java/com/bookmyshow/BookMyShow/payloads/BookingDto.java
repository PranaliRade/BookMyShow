package com.bookmyshow.BookMyShow.payloads;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.awt.print.PrinterJob;
import java.util.List;

@Getter@Setter
@Component
public class BookingDto {


        private UserDto UserDto;
        //        private String userName;
//        private String userEmail;
//        private String movieName;
//        private String poster;
        private String location;
        private String theater;
        private List<String> bookedSeats;
        private String time;
        private List<FoodItemDto> foodItems;
        private String price;
        private int totalPrice;
private MovieDto movieDto;

    }


