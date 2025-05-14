package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.GenresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenresRepository extends JpaRepository<GenresModel, Integer>, JpaSpecificationExecutor<GenresModel> {
}
