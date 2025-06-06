package com.jorgea.PFC.repository;

import com.jorgea.PFC.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
} 