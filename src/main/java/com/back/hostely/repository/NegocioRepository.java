package com.back.hostely.repository;

import com.back.hostely.model.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepository extends JpaRepository<Negocio, Integer> {
    List<Negocio> findByRazonSocialContainingIgnoreCase(String razonSocial);
    List<Negocio> findByPais(Integer pais);
    List<Negocio> findByTipo(Integer tipo);
}