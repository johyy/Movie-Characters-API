package com.example.java_assignment_3.services.movie;

import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImp implements  MovieService {

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImp.class);
    private final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Collection<Movie> findAllMoviesByFranchiseId(int id) {
        return movieRepository.findAllMoviesByFranchiseId(id);
    }
}
