package com.back.hostely.repository;

import com.back.hostely.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {
    List<Insumo> findByNombreContainingIgnoreCase(String nombre);
    List<Insumo> findByNegocioId(Integer negocioId);
}