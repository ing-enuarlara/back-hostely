package com.back.hostely.repository;

import com.back.hostely.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    List<Rol> findByNegocioId(Integer negocioId);

    @Query("SELECT r FROM Rol r WHERE r.negocioId = :negocioId OR r.id IN :globalIds")
    List<Rol> findByNegocioWithGlobal(@Param("negocioId") Integer negocioId,
            @Param("globalIds") List<Integer> globalIds);
}