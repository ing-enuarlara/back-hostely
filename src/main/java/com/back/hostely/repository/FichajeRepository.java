package com.back.hostely.repository;

import com.back.hostely.model.Fichaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FichajeRepository extends JpaRepository<Fichaje, Integer> {
    List<Fichaje> findByUsuarioId(Integer usuarioId);
    List<Fichaje> findByPuestoId(Integer puestoId);
    List<Fichaje> findBySedeId(Integer sedeId);
    List<Fichaje> findByNegocioId(Integer negocioId);

    Optional<Fichaje> findByEnlace(String enlace);
}