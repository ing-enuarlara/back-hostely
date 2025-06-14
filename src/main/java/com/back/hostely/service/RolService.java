package com.back.hostely.service;

import com.back.hostely.model.Rol;
import com.back.hostely.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;

    public List<Rol> listarTodos() {
        return repository.findAll();
    }

    public Optional<Rol> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Rol> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Rol crear(Rol rol) {
        return repository.save(rol);
    }

    public Rol actualizar(Integer id, Rol datos) {
        return repository.findById(id).map(r -> {
            r.setNombre(datos.getNombre());
            r.setNegocioId(datos.getNegocioId());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}