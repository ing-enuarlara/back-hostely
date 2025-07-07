package com.back.hostely.repository;

import com.back.hostely.model.PermisoDependencia;
import com.back.hostely.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermisoDependenciaRepository extends JpaRepository<PermisoDependencia, Long> {
    List<PermisoDependencia> findByPermiso(Permiso permiso);
}