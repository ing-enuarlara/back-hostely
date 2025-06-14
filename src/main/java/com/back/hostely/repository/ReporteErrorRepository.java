package com.back.hostely.repository;

import com.back.hostely.model.ReporteError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteErrorRepository extends JpaRepository<ReporteError, Integer> {
    List<ReporteError> findByUsuarioId(Integer usuarioId);
    List<ReporteError> findByNegocioId(Integer negocioId);
}