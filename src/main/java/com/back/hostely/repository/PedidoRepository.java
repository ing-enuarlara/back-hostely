package com.back.hostely.repository;

import com.back.hostely.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findBySedeId(Integer sedeId);
    List<Pedido> findByProveedorId(Integer proveedorId);
}