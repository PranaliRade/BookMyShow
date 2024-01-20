package com.bookmyshow.BookMyShow.repositories;

import com.bookmyshow.BookMyShow.entites.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository <Movies,Long>{
    List<Movies> findByTitleContainingIgnoreCase(String keyword);
}
