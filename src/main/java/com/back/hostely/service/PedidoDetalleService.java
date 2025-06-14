package com.back.hostely.service;

import com.back.hostely.model.PedidoDetalle;
import com.back.hostely.repository.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository repository;

    public List<PedidoDetalle> listarTodos() {
        return repository.findAll();
    }

    public Optional<PedidoDetalle> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<PedidoDetalle> buscarPorPedido(Integer pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }

    public PedidoDetalle crear(PedidoDetalle detalle) {
        return repository.save(detalle);
    }

    public PedidoDetalle actualizar(Integer id, PedidoDetalle datos) {
        return repository.findById(id).map(d -> {
            d.setPedidoId(datos.getPedidoId());
            d.setInsumoId(datos.getInsumoId());
            d.setCantidad(datos.getCantidad());
            d.setObservaciones(datos.getObservaciones());
            return repository.save(d);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}