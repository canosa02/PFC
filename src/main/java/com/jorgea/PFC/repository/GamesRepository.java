package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.GamesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GamesRepository extends JpaRepository<GamesModel, Integer>, JpaSpecificationExecutor<GamesModel> {
}
