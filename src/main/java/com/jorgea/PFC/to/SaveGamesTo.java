package com.jorgea.PFC.to;


import java.util.List;

public class SaveGamesTo {
    private String title;
    private String description;
    private String developer;
    private String releaseDate;
    private double rating;
    private List<GenresNameTo> genres;

    public SaveGamesTo() {
    }

    public SaveGamesTo(String title, String description, String developer, String releaseDate, double rating, List<GenresNameTo> genres) {
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genres = genres;
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

    public List<GenresNameTo> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresNameTo> genres) {
        this.genres = genres;
    }
}
