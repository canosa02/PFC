package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UsersModel, Integer>, JpaSpecificationExecutor<UsersModel> {
}
