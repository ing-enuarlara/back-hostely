package com.back.hostely.service;

import com.back.hostely.model.Receta;
import com.back.hostely.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository repository;

    public List<Receta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Receta> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Receta> buscarPorProducto(Integer productoId) {
        return repository.findByProductoId(productoId);
    }

    public Receta crear(Receta r) {
        return repository.save(r);
    }

    public Receta actualizar(Integer id, Receta datos) {
        return repository.findById(id).map(r -> {
            r.setProductoId(datos.getProductoId());
            r.setInsumoId(datos.getInsumoId());
            r.setCantidadRequerida(datos.getCantidadRequerida());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}