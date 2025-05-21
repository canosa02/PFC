package com.jorgea.PFC.model;

import jakarta.persistence.*;

public class GenresInGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genresInGamesId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GamesModel game;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenresModel genre;

    public GenresInGames() {
    }

    public GenresInGames(Integer genresInGamesId, GamesModel game, GenresModel genre) {
        this.genresInGamesId = genresInGamesId;
        this.game = game;
        this.genre = genre;
    }

    public Integer getGenresInGamesId() {
        return genresInGamesId;
    }

    public void setGenresInGamesId(Integer genresInGamesId) {
        this.genresInGamesId = genresInGamesId;
    }

    public GamesModel getGame() {
        return game;
    }

    public void setGame(GamesModel game) {
        this.game = game;
    }

    public GenresModel getGenre() {
        return genre;
    }

    public void setGenre(GenresModel genre) {
        this.genre = genre;
    }
}
