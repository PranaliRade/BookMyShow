package com.bookmyshow.BookMyShow.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String moviePoster;
    private String movieName;
    private String releaseDate;
    private String category;
    private String genre;
    private String rating;
    private String country;
}
