package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.SeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeriesRepository extends JpaRepository<SeriesModel, Integer>, JpaSpecificationExecutor<SeriesModel> {
}
