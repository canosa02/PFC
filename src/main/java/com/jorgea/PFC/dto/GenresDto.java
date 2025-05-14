package com.jorgea.PFC.dto;

import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.model.SeriesModel;

import java.util.List;

public class GenresDto {
    private int genresId;
    private String genreName;
    private List<FilmsDto> films;
    private List<SeriesDto> series;

    public GenresDto() {
    }

    public GenresDto(int genresId, String genreName, List<FilmsDto> films, List<SeriesDto> series) {
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
