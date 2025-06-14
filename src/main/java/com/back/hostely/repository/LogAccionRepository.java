package com.back.hostely.repository;

import com.back.hostely.model.LogAccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogAccionRepository extends JpaRepository<LogAccion, Integer> {
}