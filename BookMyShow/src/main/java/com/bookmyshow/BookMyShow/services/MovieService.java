package com.bookmyshow.BookMyShow.services;

import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.payloads.MovieDto;

import java.util.List;

public interface MovieService {
     List<Movies> getAllMovies();
     public MovieDto createMovie(MovieDto movieDto);

}
