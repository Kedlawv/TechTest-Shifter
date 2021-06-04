package com.wabu.techTest.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MoviesController {

    final MoviesRepository repository;

    public MoviesController(MoviesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return repository.addMovie(movie);
    }

    @GetMapping("/movies/{id}/description")
    public ResponseEntity<String> getMovieDescription(@PathVariable Integer id) {
        Optional<Movie> movieOptional = repository.findById(id);
        if (movieOptional.isPresent()) {
            return new ResponseEntity<String>(movieOptional.get().getDescription(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Movie with id = " + id + " not found", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/movies")
    public void updateMovie(@RequestBody Movie movie) {
        // out of time
    }
}
