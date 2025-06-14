package com.back.hostely.service;

import com.back.hostely.model.Sede;
import com.back.hostely.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    private SedeRepository repository;

    public List<Sede> listarTodos() {
        return repository.findAll();
    }

    public Optional<Sede> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Sede> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Sede crear(Sede sede) {
        return repository.save(sede);
    }

    public Sede actualizar(Integer id, Sede datos) {
        return repository.findById(id).map(s -> {
            s.setNombre(datos.getNombre());
            s.setDireccion(datos.getDireccion());
            s.setIngreso(datos.getIngreso());
            s.setNegocioId(datos.getNegocioId());
            return repository.save(s);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}