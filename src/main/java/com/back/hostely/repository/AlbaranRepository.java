package com.back.hostely.repository;

import com.back.hostely.model.Albaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbaranRepository extends JpaRepository<Albaran, Integer> {
    List<Albaran> findBySedeId(Integer sedeId);
    List<Albaran> findByUsuarioId(Integer usuarioId);
}