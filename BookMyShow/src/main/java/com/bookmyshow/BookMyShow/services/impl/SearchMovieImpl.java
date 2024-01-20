package com.bookmyshow.BookMyShow.services.impl;

import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.repositories.MovieRepository;
import com.bookmyshow.BookMyShow.services.SearchMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchMovieImpl implements SearchMovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movies> searchMovies(String keyword) {
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
