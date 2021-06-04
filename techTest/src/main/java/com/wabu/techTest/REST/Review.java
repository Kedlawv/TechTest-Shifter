package com.wabu.techTest.REST;

import java.util.Objects;

public class Review {

    private String reviewersName;
    private String reviewText;
    private int likes;

    public Review(String reviewersName, String reviewText) {
        this.reviewersName = reviewersName;
        this.reviewText = reviewText;
    }

    public String getReviewersName() {
        return reviewersName;
    }

    public void setReviewersName(String reviewersName) {
        this.reviewersName = reviewersName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getLikes() {
        return likes;
    }

    public void addLike() {
        this.likes++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return likes == review.likes &&
                Objects.equals(reviewersName, review.reviewersName) &&
                Objects.equals(reviewText, review.reviewText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewersName, reviewText, likes);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewersName='" + reviewersName + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", likes=" + likes +
                '}';
    }
}
