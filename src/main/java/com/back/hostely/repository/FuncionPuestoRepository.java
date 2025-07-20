package com.back.hostely.repository;

import com.back.hostely.model.FuncionPuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionPuestoRepository extends JpaRepository<FuncionPuesto, Integer> {
    List<FuncionPuesto> findByPuestoId(Integer puestoId);
}