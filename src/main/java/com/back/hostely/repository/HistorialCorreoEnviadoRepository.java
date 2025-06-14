package com.back.hostely.repository;

import com.back.hostely.model.HistorialCorreoEnviado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialCorreoEnviadoRepository extends JpaRepository<HistorialCorreoEnviado, Integer> {
    List<HistorialCorreoEnviado> findByRemitenteId(Integer remitenteId);
    List<HistorialCorreoEnviado> findByDestinatarioId(Integer destinatarioId);
    List<HistorialCorreoEnviado> findByNegocioId(Integer negocioId);
}