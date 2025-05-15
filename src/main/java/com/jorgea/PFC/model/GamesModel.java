package com.jorgea.PFC.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "games")
public class GamesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    private String developer;
    private String releaseDate;
    private double rating;

    @ManyToMany(mappedBy = "games")
    private List<GenresModel> genres;

    public GamesModel() {
    }

    public GamesModel(Integer gameId, String title, String description, String developer, String releaseDate, double rating, List<GenresModel> genres) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genres = genres;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
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

    public List<GenresModel> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresModel> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "GamesModel{" +
                "gameId=" + gameId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", developer='" + developer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", genres=" + genres +
                '}';
    }
}
