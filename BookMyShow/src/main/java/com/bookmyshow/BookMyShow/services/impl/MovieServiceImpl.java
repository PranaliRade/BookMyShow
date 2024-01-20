package com.bookmyshow.BookMyShow.services.impl;


import com.bookmyshow.BookMyShow.entites.Movies;
import com.bookmyshow.BookMyShow.exceptions.ResourceNotFoundException;
import com.bookmyshow.BookMyShow.payloads.MovieDto;
import com.bookmyshow.BookMyShow.repositories.MovieRepository;
import com.bookmyshow.BookMyShow.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MovieDto movieDto;

    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
       Movies movies=this.modelMapper.map(movieDto , Movies.class);
        movies.setMoviePoster(movieDto.getMoviePoster());
        movies.setMovieName(movieDto.getMovieName());
        movies.setCategory(movieDto.getCategory());
        movies.setCountry(movieDto.getCountry());
        movies.setRating(movieDto.getRating());
        movies.setReleaseDate(movieDto.getReleaseDate());
        movies.setGenre(movies.getGenre());
        Movies updatedMovie=this.movieRepository.save(movies);
        MovieDto movieDto1=this.modelMapper.map(movies , MovieDto.class);


        return movieDto1;
    }
}


