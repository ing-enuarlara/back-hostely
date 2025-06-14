package com.back.hostely.service;

import com.back.hostely.model.HistorialCorreoEnviado;
import com.back.hostely.repository.HistorialCorreoEnviadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialCorreoEnviadoService {

    @Autowired
    private HistorialCorreoEnviadoRepository repository;

    public List<HistorialCorreoEnviado> listarTodos() {
        return repository.findAll();
    }

    public Optional<HistorialCorreoEnviado> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<HistorialCorreoEnviado> buscarPorRemitente(Integer remitenteId) {
        return repository.findByRemitenteId(remitenteId);
    }

    public List<HistorialCorreoEnviado> buscarPorDestinatario(Integer destinatarioId) {
        return repository.findByDestinatarioId(destinatarioId);
    }

    public List<HistorialCorreoEnviado> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }
}