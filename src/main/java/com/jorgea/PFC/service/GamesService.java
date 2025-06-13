package com.jorgea.PFC.service;

import com.jorgea.PFC.to.GamesGenresTo;
import com.jorgea.PFC.to.GamesPostTo;
import com.jorgea.PFC.to.GamesPutTo;
import com.jorgea.PFC.to.GamesPatchTo;
import com.jorgea.PFC.to.GamesWithoutGenresTo;
import com.jorgea.PFC.to.PageResponseTo;

import org.springframework.data.domain.Pageable;


public interface GamesService {

    PageResponseTo<GamesGenresTo> findAllGamesWithFilters(String title, String genreName, Pageable pageable);

    GamesGenresTo findByGameId(Integer gameId);

    GamesWithoutGenresTo saveGames(GamesPostTo gamesPostTo);

    GamesGenresTo addGenresToGames(Integer gameId, Integer genreId);

    GamesWithoutGenresTo updateGames(Integer gameId, GamesPutTo gamesPutTo);

    GamesWithoutGenresTo partialUpdateGames(Integer gameId, GamesPatchTo gamesPatchTo);

    void deleteGames(Integer gameId);

    void deleteGenresFromGames(Integer gameId, Integer genreId);
}
