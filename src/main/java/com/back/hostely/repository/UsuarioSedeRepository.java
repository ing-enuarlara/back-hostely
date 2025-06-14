package com.back.hostely.repository;

import com.back.hostely.model.UsuarioSede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioSedeRepository extends JpaRepository<UsuarioSede, Integer> {
    List<UsuarioSede> findByUsuarioId(Integer usuarioId);
    List<UsuarioSede> findBySedeId(Integer sedeId);
}