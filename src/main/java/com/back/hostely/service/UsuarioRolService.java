package com.back.hostely.service;

import com.back.hostely.model.UsuarioRol;
import com.back.hostely.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolService {

    @Autowired
    private UsuarioRolRepository repository;

    public List<UsuarioRol> listarTodos() {
        return repository.findAll();
    }

    public Optional<UsuarioRol> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<UsuarioRol> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<UsuarioRol> buscarPorRol(Integer rolId) {
        return repository.findByRolId(rolId);
    }

    public UsuarioRol crear(UsuarioRol relacion) {
        return repository.save(relacion);
    }

    public UsuarioRol actualizar(Integer id, UsuarioRol datos) {
        return repository.findById(id).map(r -> {
            r.setUsuarioId(datos.getUsuarioId());
            r.setRolId(datos.getRolId());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}