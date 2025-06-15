package com.back.hostely.repository;

import com.back.hostely.model.NegocioProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioProveedorRepository extends JpaRepository<NegocioProveedor, Integer> {
    List<NegocioProveedor> findByNegocioId(Integer negocioId);
    List<NegocioProveedor> findByProveedorId(Integer proveedorId);
}