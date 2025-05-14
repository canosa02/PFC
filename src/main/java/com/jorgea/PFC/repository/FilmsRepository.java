package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.FilmsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FilmsRepository extends JpaRepository<FilmsModel, Integer>, JpaSpecificationExecutor<FilmsModel> {
}
