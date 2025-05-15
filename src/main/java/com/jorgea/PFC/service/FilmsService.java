package com.jorgea.PFC.service;

import com.jorgea.PFC.to.FilmsGenresTo;
import com.jorgea.PFC.to.FilmsTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;


public interface FilmsService {

    PageResponseTo<FilmsGenresTo> findAllFilmsWithFilters(String title, String genreName, Pageable pageable);

    FilmsGenresTo findByFilmId(Integer filmId);

    FilmsTo saveFilms(FilmsTo filmsTo);

    FilmsTo updateFilms(FilmsTo filmsTo);

    FilmsTo partialUpdateFiles(FilmsTo filmsTo);

    FilmsTo deleteFilms(FilmsTo filmsTo);
}
