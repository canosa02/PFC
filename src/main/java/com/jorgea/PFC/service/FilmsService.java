package com.jorgea.PFC.service;

import com.jorgea.PFC.dto.FilmsDto;
import com.jorgea.PFC.dto.PageResponseDto;
import com.jorgea.PFC.to.FilmsTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;


public interface FilmsService {

    PageResponseTo<FilmsTo> findAllFilmsWithFilters(String title, String genreName, Pageable pageable);

    FilmsTo findByFilmId(Integer filmId);

    FilmsTo saveFilms(FilmsTo filmsTo);

    FilmsTo updateFilms(FilmsTo filmsTo);

    FilmsTo partialUpdateFiles(FilmsTo filmsTo);

    FilmsTo deleteFilms(FilmsTo filmsTo);
}
