package com.jorgea.PFC.service;

import com.jorgea.PFC.to.GenresNameTo;
import com.jorgea.PFC.to.GenresWithoutGamesTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;

public interface GenresService {

    PageResponseTo<GenresWithoutGamesTo> findAllGenresWithFilters(String genreName, Pageable pageable);

    GenresWithoutGamesTo findByGenreId(Integer genreId);

    GenresWithoutGamesTo saveGenres(GenresNameTo genresNameTo);

    GenresWithoutGamesTo updateGenres(Integer genreId, GenresNameTo genresNameTo);

    void deleteGenres(Integer genreId);
}
