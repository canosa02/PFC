package com.jorgea.PFC.repository;


import com.jorgea.PFC.model.GenresInGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenresInGamesRepository extends JpaRepository<GenresInGames, Integer>, JpaSpecificationExecutor<GenresInGames> {
}
