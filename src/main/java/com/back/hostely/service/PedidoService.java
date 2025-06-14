package com.back.hostely.service;

import com.back.hostely.model.Pedido;
import com.back.hostely.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Pedido> buscarPorSede(Integer sedeId) {
        return repository.findBySedeId(sedeId);
    }

    public List<Pedido> buscarPorProveedor(Integer proveedorId) {
        return repository.findByProveedorId(proveedorId);
    }

    public Pedido crear(Pedido p) {
        return repository.save(p);
    }

    public Pedido actualizar(Integer id, Pedido datos) {
        return repository.findById(id).map(p -> {
            p.setSedeId(datos.getSedeId());
            p.setProveedorId(datos.getProveedorId());
            p.setFechaCreacion(datos.getFechaCreacion());
            p.setEstado(datos.getEstado());
            p.setEnviado(datos.getEnviado());
            return repository.save(p);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}