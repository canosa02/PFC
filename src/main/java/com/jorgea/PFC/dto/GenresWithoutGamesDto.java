package com.jorgea.PFC.dto;

public class GenresWithoutGamesDto {
    private int genresId;
    private String genreName;

    public GenresWithoutGamesDto() {
    }

    public GenresWithoutGamesDto(int genresId, String genreName) {
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
