package com.back.hostely.repository;

import com.back.hostely.model.TipoNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoNegocioRepository extends JpaRepository<TipoNegocio, Integer> {
    List<TipoNegocio> findByNombreContainingIgnoreCase(String nombre);
}