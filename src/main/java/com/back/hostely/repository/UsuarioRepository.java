package com.back.hostely.repository;

import com.back.hostely.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
    List<Usuario> findByNegocioId(Integer negocioId);
}