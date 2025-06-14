package com.back.hostely.repository;

import com.back.hostely.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
    List<Sede> findByNegocioId(Integer negocioId);
}