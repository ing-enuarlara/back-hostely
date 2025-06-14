package com.back.hostely.service;

import com.back.hostely.model.UsuarioSede;
import com.back.hostely.repository.UsuarioSedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSedeService {

    @Autowired
    private UsuarioSedeRepository repository;

    public List<UsuarioSede> listarTodos() {
        return repository.findAll();
    }

    public Optional<UsuarioSede> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<UsuarioSede> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<UsuarioSede> buscarPorSede(Integer sedeId) {
        return repository.findBySedeId(sedeId);
    }

    public UsuarioSede crear(UsuarioSede relacion) {
        return repository.save(relacion);
    }

    public UsuarioSede actualizar(Integer id, UsuarioSede datos) {
        return repository.findById(id).map(r -> {
            r.setUsuarioId(datos.getUsuarioId());
            r.setSedeId(datos.getSedeId());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}