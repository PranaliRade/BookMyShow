package com.bookmyshow.BookMyShow.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Data
public class FoodItemDto {
    private String itemName;
    private double price;
}
