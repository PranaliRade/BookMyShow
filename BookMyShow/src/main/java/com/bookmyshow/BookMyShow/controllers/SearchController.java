package com.bookmyshow.BookMyShow.controllers;

import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.payloads.MovieDto;
import com.bookmyshow.BookMyShow.repositories.MovieRepository;
import com.bookmyshow.BookMyShow.services.MovieService;
import com.bookmyshow.BookMyShow.services.SearchMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SearchMovieService SearchmovieService;
    @GetMapping("/search")
    public ResponseEntity<List<Movies>> searchMovies(@RequestParam String keyword) {
        List<Movies> searchedMovies = this.SearchmovieService.searchMovies(keyword);
        return new ResponseEntity<>(searchedMovies, HttpStatus.OK);
    }


    }



