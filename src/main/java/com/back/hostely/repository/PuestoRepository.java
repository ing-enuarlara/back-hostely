package com.back.hostely.repository;

import com.back.hostely.model.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Integer> {
    List<Puesto> findByNegocioId(Integer negocioId);

    @Query("SELECT p FROM Puesto p LEFT JOIN FETCH p.horarios WHERE p.negocioId = :negocioId")
    List<Puesto> findByNegocioIdWithHorarios(@Param("negocioId") Integer negocioId);
}