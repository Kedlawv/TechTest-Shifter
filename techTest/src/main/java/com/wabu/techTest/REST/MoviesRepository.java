package com.wabu.techTest.REST;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MoviesRepository {
    private static List<Movie> movies;

    static {
        movies = new ArrayList<>();
        movies.add(new Movie(1, "Matrix", "Neo is the one",
                "Wachowski Brothers/Sisters"));
        movies.get(0).addRating(Rating.FIVE);
        movies.get(0).addRating(Rating.FIVE);
        movies.get(0).addReview(new Review("SilentBob", "Mind bending goodness"));

        movies.add(new Movie(2, "Jupiter Ascending", "Cosmic opera with Mila Kunis",
                "Lana Wachowski"));
        movies.get(1).addRating(Rating.THREE);
        movies.get(1).addReview(new Review("MasterChief"
                , "Visually stunning but story is meeeee"));
    }

    public List<Movie> findAll() {
        return movies;
    }

    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movies.get(movies.indexOf(movie));
    }


    public Optional<Movie> findById(int id) {
        return movies.stream().filter(m -> m.getId() == id).findFirst();
    }


}
