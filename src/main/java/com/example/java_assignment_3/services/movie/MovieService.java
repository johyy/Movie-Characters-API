package com.example.java_assignment_3.services.movie;

import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.services.CrudService;
import org.springframework.stereotype.Repository;

public interface MovieService extends CrudService<Movie, Integer> {
}
