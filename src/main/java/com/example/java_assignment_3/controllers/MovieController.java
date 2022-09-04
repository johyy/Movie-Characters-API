package com.example.java_assignment_3.controllers;

import com.example.java_assignment_3.mappers.MovieMapper;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path="api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @Operation(summary = "Get all movies")
    @GetMapping
    public ResponseEntity findAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(movieService.findAll());
        return ResponseEntity.ok(movies);
    }

    @Operation(summary = "Get movies in a franchise")
    @GetMapping("franchise/{id}")
    public ResponseEntity<Collection<Movie>> findAllMoviesByFranchiseId(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findAllMoviesByFranchiseId(id));
    }

    @Operation(summary = "Get a movie")
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        MovieDTO movie = movieMapper.movieToMovieDto(movieService.findById(id));
        return  ResponseEntity.ok(movie);
    }

    @Operation(summary = "Add a new movie")
    @PostMapping
    public ResponseEntity add(@RequestBody Movie movie) {
        Movie m = movieService.add(movie);
        URI location = URI.create("movies/" + m.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update a movie")
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if (id != movieDTO.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDtoToMovie(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a movie")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}