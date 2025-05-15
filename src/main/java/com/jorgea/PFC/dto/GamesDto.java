package com.jorgea.PFC.dto;

import java.util.List;

public class GamesDto {
    private Integer gameId;
    private String title;
    private String description;
    private String developer;
    private String releaseDate;
    private double rating;
    private List<GenresDto> genres;

    public GamesDto() {
    }

    public GamesDto(Integer gameId, String title, String description, String developer, String releaseDate, double rating, List<GenresDto> genres) {
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

    public List<GenresDto> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresDto> genres) {
        this.genres = genres;
    }
}
