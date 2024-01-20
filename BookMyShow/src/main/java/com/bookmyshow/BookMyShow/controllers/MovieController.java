package com.bookmyshow.BookMyShow.controllers;

import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.payloads.MovieDto;
import com.bookmyshow.BookMyShow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
   @PostMapping("/post")
   public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
        MovieDto movies= this.movieService.createMovie(movieDto);
        return new ResponseEntity<MovieDto>(movies,HttpStatus.CREATED);

    }
}

