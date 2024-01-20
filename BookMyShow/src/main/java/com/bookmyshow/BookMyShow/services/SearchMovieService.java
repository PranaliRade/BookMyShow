package com.bookmyshow.BookMyShow.services;

import com.bookmyshow.BookMyShow.entites.Movies;

import java.util.List;

public interface SearchMovieService {
    public  List<Movies> searchMovies(String keyword);
}
