package com.jorgea.PFC.service;

import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesTo;
import com.jorgea.PFC.to.PageResponseTo;
import org.springframework.data.domain.Pageable;


public interface GamesService {

    PageResponseTo<GamesGenresTo> findAllGamesWithFilters(String title, String genreName, Pageable pageable);

    GamesGenresTo findByGamesId(Integer gameId);

    GamesTo saveGames(GamesTo gamesTo);

    GamesTo updateGames(GamesTo gamesTo);

    GamesTo partialUpdateGames(GamesTo gamesTo);

    GamesTo deleteGames(GamesTo gamesTo);
}
