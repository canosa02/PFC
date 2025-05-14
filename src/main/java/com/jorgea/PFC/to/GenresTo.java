package com.jorgea.PFC.to;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.SeriesDto;

import java.util.List;

public class GenresTo {
    private int genresId;
    private String genreName;
    private List<FilmsDto> films;
    private List<SeriesDto> series;

    public GenresTo() {
    }

    public GenresTo(int genresId, String genreName, List<FilmsDto> films, List<SeriesDto> series) {
        this.genresId = genresId;
        this.genreName = genreName;
        this.films = films;
        this.series = series;
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

    public List<FilmsDto> getFilms() {
        return films;
    }

    public void setFilms(List<FilmsDto> films) {
        this.films = films;
    }

    public List<SeriesDto> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesDto> series) {
        this.series = series;
    }
}
