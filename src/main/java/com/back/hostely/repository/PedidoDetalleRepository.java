package com.back.hostely.repository;

import com.back.hostely.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Integer> {
    List<PedidoDetalle> findByPedidoId(Integer pedidoId);
}