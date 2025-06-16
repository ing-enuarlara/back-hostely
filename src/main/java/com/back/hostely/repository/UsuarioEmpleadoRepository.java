package com.back.hostely.repository;

import com.back.hostely.model.UsuarioEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioEmpleadoRepository extends JpaRepository<UsuarioEmpleado, Integer> {
    List<UsuarioEmpleado> findByUsuarioId(Integer usuarioId);
}