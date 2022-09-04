package com.example.java_assignment_3.repositories;

import com.example.java_assignment_3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM Movie WHERE Movie.franchise_id = ?1", nativeQuery = true)
    Collection<Movie> findAllMoviesByFranchiseId(int id);
}
