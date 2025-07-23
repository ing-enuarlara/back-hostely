package com.back.hostely.repository;

import com.back.hostely.model.HorarioPuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioPuestoRepository extends JpaRepository<HorarioPuesto, Integer> {
    List<HorarioPuesto> findByPuestoId(Integer puestoId);
}