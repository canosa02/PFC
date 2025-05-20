package com.jorgea.PFC.dto;

import com.jorgea.PFC.validation.StringNotBlank;

public class GamesPutDto {

    @StringNotBlank
    private String title;

    @StringNotBlank
    private String description;

    @StringNotBlank
    private String developer;

    @StringNotBlank
    private String releaseDate;

    private double rating;

    public GamesPutDto() {
    }

    public GamesPutDto(String title, String description, String developer, String releaseDate, double rating) {
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.rating = rating;
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
}
