package com.back.hostely.repository;

import com.back.hostely.model.Fichaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichajeRepository extends JpaRepository<Fichaje, Integer> {
    List<Fichaje> findByUsuarioId(Integer usuarioId);
    List<Fichaje> findBySedeId(Integer sedeId);
}