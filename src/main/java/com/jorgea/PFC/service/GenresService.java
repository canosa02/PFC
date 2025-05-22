package com.jorgea.PFC.service;

import com.jorgea.PFC.to.GenresWithoutGamesTo;
import com.jorgea.PFC.to.PageResponseTo;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface GenresService {

    PageResponseTo<GenresWithoutGamesTo> findALlGenresWithFilters(String genreName, Pageable pageable);

    GenresWithoutGamesTo findByGenreId(Integer genreId);
}
