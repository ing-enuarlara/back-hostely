package com.back.hostely.repository;

import com.back.hostely.model.HistorialAccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialAccionRepository extends JpaRepository<HistorialAccion, Integer> {
    List<HistorialAccion> findByUsuarioId(Integer usuarioId);
    List<HistorialAccion> findByNegocioId(Integer negocioId);
}