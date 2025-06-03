package com.jorgea.PFC.repository;


import com.jorgea.PFC.model.GenresInGamesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface GenresInGamesRepository extends JpaRepository<GenresInGamesModel, Integer>, JpaSpecificationExecutor<GenresInGamesModel> {
    Optional<GenresInGamesModel> findByGame_GameIdAndGenre_GenreId(Integer gameId, Integer genreId);
}
