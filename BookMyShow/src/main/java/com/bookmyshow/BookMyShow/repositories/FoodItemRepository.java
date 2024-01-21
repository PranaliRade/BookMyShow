package com.bookmyshow.BookMyShow.repositories;

import com.bookmyshow.BookMyShow.entites.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
}
