package com.example.java_assignment_3.controllers;

import com.example.java_assignment_3.mappers.MovieMapper;
import com.example.java_assignment_3.models.Movie;
import com.example.java_assignment_3.models.dtos.movie.MovieDTO;
import com.example.java_assignment_3.services.movie.MovieService;
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

    @GetMapping
    public ResponseEntity findAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(movieService.findAll());
        return ResponseEntity.ok(movies);
    }

    @GetMapping("franchise/{id}")
    public ResponseEntity<Collection<Movie>> findAllMoviesByFranchiseId(@PathVariable int id) {
        return ResponseEntity.ok(movieService.findAllMoviesByFranchiseId(id));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        MovieDTO movie = movieMapper.movieToMovieDto(movieService.findById(id));
        return  ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Movie movie) {
        Movie m = movieService.add(movie);
        URI location = URI.create("movies/" + m.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if (id != movieDTO.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDtoToMovie(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}