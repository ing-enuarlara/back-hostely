package com.back.hostely.repository;

import com.back.hostely.model.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Integer> {
    List<Puesto> findByNegocioId(Integer negocioId);
}