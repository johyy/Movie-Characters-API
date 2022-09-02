package com.example.java_assignment_3.models.dtos.movie;

import lombok.Data;

import java.util.Set;

@Data
public class MovieDTO {
    private int movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieReleaseYear;
    private String movieDirector;
    private String moviePicture;
    private String movieTrailer;
    private Set<Integer> characters;
    private int franchise;
}
