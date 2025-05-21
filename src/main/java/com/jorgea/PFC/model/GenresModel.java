package com.jorgea.PFC.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "genres")
public class GenresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;
    private String genreName;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = jakarta.persistence.FetchType.LAZY)
    private List<GenresInGames> games;

    public GenresModel() {
    }

    public GenresModel(String genreName, List<GenresInGames> games) {
        this.genreName = genreName;
        this.games = games;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<GenresInGames> getGames() {
        return games;
    }

    public void setGames(List<GenresInGames> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "GenresModel{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", games=" + games +
                '}';
    }
}
