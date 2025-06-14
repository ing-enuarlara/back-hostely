package com.back.hostely.service;

import com.back.hostely.model.Venta;
import com.back.hostely.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository repository;

    public List<Venta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Venta> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Venta> buscarPorSede(Integer sedeId) {
        return repository.findBySedeId(sedeId);
    }

    public List<Venta> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Venta crear(Venta v) {
        return repository.save(v);
    }

    public Venta actualizar(Integer id, Venta datos) {
        return repository.findById(id).map(v -> {
            v.setSedeId(datos.getSedeId());
            v.setUsuarioId(datos.getUsuarioId());
            v.setFecha(datos.getFecha());
            v.setTotal(datos.getTotal());
            return repository.save(v);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}