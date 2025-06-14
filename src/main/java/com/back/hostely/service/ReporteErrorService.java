package com.back.hostely.service;

import com.back.hostely.model.ReporteError;
import com.back.hostely.repository.ReporteErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteErrorService {

    @Autowired
    private ReporteErrorRepository repository;

    public List<ReporteError> listarTodos() {
        return repository.findAll();
    }

    public Optional<ReporteError> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<ReporteError> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<ReporteError> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }
}