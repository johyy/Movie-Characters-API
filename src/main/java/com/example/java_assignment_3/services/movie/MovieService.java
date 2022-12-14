package com.example.java_assignment_3.services.movie;

import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.services.CrudService;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface MovieService extends CrudService<Movie, Integer> {

    Collection<Movie> findAllMoviesByFranchiseId(int id);
    void nullAllMoviesWithCertainFranchiseId(int id);
    void setFranchiseIdToSpecifiedMovieIds(int fra_id, int movie_id);
    Movie updateCharacterInMovie(List<Integer> ids, int id);
}
