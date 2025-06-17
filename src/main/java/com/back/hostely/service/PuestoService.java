package com.back.hostely.service;

import com.back.hostely.model.Puesto;
import com.back.hostely.repository.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService {

    @Autowired
    private PuestoRepository repository;

    public List<Puesto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Puesto> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Puesto> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Puesto crear(Puesto puesto) {
        return repository.save(puesto);
    }

    public Puesto actualizar(Integer id, Puesto datos) {
        return repository.findById(id).map(s -> {
            s.setNombre(datos.getNombre());
            s.setDescripcion(datos.getDescripcion());
            s.setNegocioId(datos.getNegocioId());
            return repository.save(s);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}