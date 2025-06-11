package com.back.hostely.repository;

import com.back.hostely.model.UsuarioSede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioSedeRepository extends JpaRepository<UsuarioSede, Long> {
    List<UsuarioSede> findByUsuarioId(Long usuarioId);
}