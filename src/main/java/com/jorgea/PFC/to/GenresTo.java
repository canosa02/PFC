package com.jorgea.PFC.to;

import com.jorgea.PFC.dto.GamesDto;

import java.util.List;

public class GenresTo {
    private int genreId;
    private String genreName;
    private List<GamesDto> games;

    public GenresTo() {
    }

    public GenresTo(int genreId, String genreName, List<GamesDto> games) {
        this.genreId = genreId;
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

    public List<GamesDto> getGames() {
        return games;
    }

    public void setGames(List<GamesDto> games) {
        this.games = games;
    }
}
