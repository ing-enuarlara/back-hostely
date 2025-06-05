package com.back.hostely.repository;

import com.back.hostely.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeRepository extends JpaRepository<Sede, Long> {
    Sede findByNombre(String nombre);
}