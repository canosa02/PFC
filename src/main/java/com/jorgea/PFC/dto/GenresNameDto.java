package com.jorgea.PFC.dto;

import com.jorgea.PFC.validation.StringNotBlank;

public class GenresNameDto {
    @StringNotBlank
    private String genreName;

    public GenresNameDto() {
    }

    public GenresNameDto(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
