package com.back.hostely.repository;

import com.back.hostely.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    List<Rol> findByNegocioId(Integer negocioId);
}