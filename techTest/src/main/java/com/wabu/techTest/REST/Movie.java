package com.wabu.techTest.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie {

    private int id;
    private String name;
    private String description;
    private String director;
    private List<Review> reviews;
    private List<Rating> ratings;
    private int likes;

    {
        reviews = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    public Movie(int id, String name, String description, String director) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public int getLikes() {
        return likes;
    }

    public void addLike() {
        this.likes++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                likes == movie.likes &&
                Objects.equals(name, movie.name) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(reviews, movie.reviews) &&
                Objects.equals(ratings, movie.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, director, reviews, ratings, likes);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", reviews=" + reviews +
                ", ratings=" + ratings +
                ", likes=" + likes +
                '}';
    }
}
