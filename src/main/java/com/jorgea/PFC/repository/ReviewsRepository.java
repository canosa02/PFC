package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.ReviewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReviewsRepository extends JpaRepository<ReviewsModel, Integer>, JpaSpecificationExecutor<ReviewsModel> {
}
