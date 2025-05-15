package com.jorgea.PFC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Id;
import java.util.List;

@Entity
@Table(name = "genres")
public class GenresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genresId;
    private String genreName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "game_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<GamesModel> games;

    public GenresModel() {
    }

    public GenresModel(String genreName, List<GamesModel> games) {
        this.genreName = genreName;
        this.games = games;
    }

    public int getGenresId() {
        return genresId;
    }

    public void setGenresId(int genresId) {
        this.genresId = genresId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<GamesModel> getGames() {
        return games;
    }

    public void setGames(List<GamesModel> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "GenresModel{" +
                "genresId=" + genresId +
                ", genreName='" + genreName + '\'' +
                ", games=" + games +
                '}';
    }
}
