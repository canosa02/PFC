package com.jorgea.PFC.to;

public class GenresWithoutGamesTo {
    private int genresId;
    private String genreName;

    public GenresWithoutGamesTo() {
    }

    public GenresWithoutGamesTo(int genresId, String genreName) {
        this.genresId = genresId;
        this.genreName = genreName;
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
}

