package com.jorgea.PFC.dto;

import java.util.List;

public class FilmsGenresDto {
    private Integer filmId;
    private String title;
    private String description;
    private String director;
    private String releaseDate;
    private double rating;
    private List<GenresNameDto> genres;

    public FilmsGenresDto() {
    }

    public FilmsGenresDto(Integer filmId, String title, String description, String director, String releaseDate, double rating, List<GenresNameDto> genres) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genres = genres;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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

    public List<GenresNameDto> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresNameDto> genres) {
        this.genres = genres;
    }



}
