package com.back.hostely.repository;

import com.back.hostely.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    boolean existsByNombre(String nombre);
}