package com.example.java_assignment_3.repositories;

import com.example.java_assignment_3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //business logic here
}
