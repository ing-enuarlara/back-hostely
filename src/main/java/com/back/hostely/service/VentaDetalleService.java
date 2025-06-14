package com.back.hostely.service;

import com.back.hostely.model.VentaDetalle;
import com.back.hostely.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetalleService {

    @Autowired
    private VentaDetalleRepository repository;

    public List<VentaDetalle> listarTodos() {
        return repository.findAll();
    }

    public Optional<VentaDetalle> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<VentaDetalle> buscarPorVenta(Integer ventaId) {
        return repository.findByVentaId(ventaId);
    }

    public VentaDetalle crear(VentaDetalle detalle) {
        return repository.save(detalle);
    }

    public VentaDetalle actualizar(Integer id, VentaDetalle datos) {
        return repository.findById(id).map(d -> {
            d.setVentaId(datos.getVentaId());
            d.setProductoId(datos.getProductoId());
            d.setCantidad(datos.getCantidad());
            return repository.save(d);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}