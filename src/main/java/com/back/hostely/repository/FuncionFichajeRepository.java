package com.back.hostely.repository;

import com.back.hostely.model.FuncionFichaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionFichajeRepository extends JpaRepository<FuncionFichaje, Integer> {
    List<FuncionFichaje> findByFichajeId(Integer fichajeId);
}