package com.example.java_assignment_3.services.movie;

import com.example.java_assignment_3.exceptions.CharacterNotFoundException;
import com.example.java_assignment_3.exceptions.MovieNotFoundException;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class MovieServiceImp implements  MovieService {

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImp.class);
    private final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
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

    @Override
    @Transactional
    public void nullAllMoviesWithCertainFranchiseId(int id) {
        movieRepository.nullAllMoviesWithCertainFranchiseId(id);
    }

    @Override
    @Transactional
    public void setFranchiseIdToSpecifiedMovieIds(int fra_id, int movie_id) {
        movieRepository.setFranchiseIdToSpecifiedMovieIds(fra_id, movie_id);
    }

    @Override
    public Movie updateCharacterInMovie(List<Integer> ids, int id){
        Movie movie = movieRepository.findById(id).get();
        movie.updateCharactersToMovie(ids);
        return movieRepository.save(movie);
    }
}
