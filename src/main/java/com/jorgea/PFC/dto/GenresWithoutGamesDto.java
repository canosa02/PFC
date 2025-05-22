package com.jorgea.PFC.dto;

public class GenresWithoutGamesDto {
    private int genreId;
    private String genreName;

    public GenresWithoutGamesDto() {
    }

    public GenresWithoutGamesDto(int genreId, String genreName) {
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
