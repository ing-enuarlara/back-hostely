package com.back.hostely.service;

import com.back.hostely.model.TipoNegocio;
import com.back.hostely.repository.TipoNegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoNegocioService {

    @Autowired
    private TipoNegocioRepository repository;

    public List<TipoNegocio> listarTodos() {
        return repository.findAll();
    }

    public Optional<TipoNegocio> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<TipoNegocio> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public TipoNegocio crear(TipoNegocio tipo) {
        return repository.save(tipo);
    }

    public TipoNegocio actualizar(Integer id, TipoNegocio datos) {
        return repository.findById(id).map(tipo -> {
            tipo.setNombre(datos.getNombre());
            tipo.setDescripcion(datos.getDescripcion());
            return repository.save(tipo);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}