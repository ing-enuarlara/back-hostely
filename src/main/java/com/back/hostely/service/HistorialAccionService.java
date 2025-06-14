package com.back.hostely.service;

import com.back.hostely.model.HistorialAccion;
import com.back.hostely.repository.HistorialAccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialAccionService {

    @Autowired
    private HistorialAccionRepository repository;

    public List<HistorialAccion> listarTodos() {
        return repository.findAll();
    }

    public Optional<HistorialAccion> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<HistorialAccion> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<HistorialAccion> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }
}