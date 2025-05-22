package com.jorgea.PFC.to;

public class GenresWithoutGamesTo {
    private int genreId;
    private String genreName;

    public GenresWithoutGamesTo() {
    }

    public GenresWithoutGamesTo(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
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
}

