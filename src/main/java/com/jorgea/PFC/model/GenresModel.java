package com.jorgea.PFC.model;

import jakarta.persistence.*;

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
            name = "film_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<FilmsModel> films;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "serie_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "serie_id")
    )
    private List<SeriesModel> series;

    public GenresModel() {
    }

    public GenresModel(String genreName, List<FilmsModel> films) {
        this.genreName = genreName;
        this.films = films;
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

    public List<FilmsModel> getFilms() {
        return films;
    }

    public void setFilms(List<FilmsModel> films) {
        this.films = films;
    }

    public List<SeriesModel> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesModel> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "GenresModel{" +
                "genresId=" + genresId +
                ", genreName='" + genreName + '\'' +
                ", films=" + films +
                ", series=" + series +
                '}';
    }
}
