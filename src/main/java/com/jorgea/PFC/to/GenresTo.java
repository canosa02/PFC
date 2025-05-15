package com.jorgea.PFC.to;

import com.jorgea.PFC.dto.GamesDto;

import java.util.List;

public class GenresTo {
    private int genresId;
    private String genreName;
    private List<GamesDto> games;

    public GenresTo() {
    }

    public GenresTo(int genresId, String genreName, List<GamesDto> games) {
        this.genresId = genresId;
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

    public List<GamesDto> getGames() {
        return games;
    }

    public void setGames(List<GamesDto> games) {
        this.games = games;
    }
}
