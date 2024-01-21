package com.bookmyshow.BookMyShow.repositories;

import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Movies> findByUsername(String userName);
}
