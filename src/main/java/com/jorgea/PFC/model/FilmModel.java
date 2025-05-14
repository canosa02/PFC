package com.jorgea.PFC.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "films")
public class FilmModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    private String title;
    private String description;
    private String director;
    private String releaseDate;
    private double rating;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "films")
    private List<GenresModel> genres;


    public FilmModel(int filmId, String title, String description, String director, String releaseDate, double rating) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
