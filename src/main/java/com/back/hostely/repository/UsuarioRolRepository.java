package com.back.hostely.repository;

import com.back.hostely.model.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {
    List<UsuarioRol> findByUsuarioId(Integer usuarioId);
    List<UsuarioRol> findByRolId(Integer rolId);
}