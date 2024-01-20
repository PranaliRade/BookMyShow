package com.bookmyshow.BookMyShow.repositories;

import com.bookmyshow.BookMyShow.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
