package com.jorgea.PFC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres_in_games")
public class GenresInGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreInGameId;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private GamesModel game;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private GenresModel genre;

    public GenresInGames() {
    }

    public GenresInGames(Integer genreInGameId, GamesModel game, GenresModel genre) {
        this.genreInGameId = genreInGameId;
        this.game = game;
        this.genre = genre;
    }

    public Integer getGenreInGameId() {
        return genreInGameId;
    }

    public void setGenreInGameId(Integer genreInGameId) {
        this.genreInGameId = genreInGameId;
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
