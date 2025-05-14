package com.jorgea.PFC.service;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.PageResponseDto;
import org.springframework.data.domain.Pageable;


public interface FilmsService {

    PageResponseDto<FilmsDto> findAllFilmsWithFilters(String title, String genreName, Pageable pageable);

    FilmsDto findByFilmId(Integer filmId);

    FilmsDto saveFilms(FilmsDto filmsDto);

    FilmsDto updateFilms(FilmsDto filmsDto);

    FilmsDto partialUpdateFiles(FilmsDto filmsDto);

    FilmsDto deleteFilms(FilmsDto filmsDto);
}
