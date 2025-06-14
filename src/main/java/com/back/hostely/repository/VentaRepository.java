package com.back.hostely.repository;

import com.back.hostely.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findBySedeId(Integer sedeId);
    List<Venta> findByUsuarioId(Integer usuarioId);
}