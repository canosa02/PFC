package com.jorgea.PFC.to;

import com.jorgea.PFC.dto.GenresDto;
import com.jorgea.PFC.dto.ReviewsDto;

import java.util.List;

public class GamesWithReviewsTo {
    private String title;
    private String description;
    private String developer;
    private String releaseDate;
    private double rating;
    private List<GenresTo> genres;
    private List<ReviewsTo> reviews;

    public GamesWithReviewsTo() {
    }

    public GamesWithReviewsTo(String title, String description, String developer, String releaseDate, double rating, List<GenresTo> genres, List<ReviewsTo> reviews) {
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genres = genres;
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<GenresTo> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresTo> genres) {
        this.genres = genres;
    }

    public List<ReviewsTo> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsTo> reviews) {
        this.reviews = reviews;
    }
}
