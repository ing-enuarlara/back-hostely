package com.back.hostely.service;

import com.back.hostely.model.LogAccion;
import com.back.hostely.repository.LogAccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogAccionService {

    @Autowired
    private LogAccionRepository repository;

    public List<LogAccion> listarTodos() {
        return repository.findAll();
    }

    public Optional<LogAccion> buscarPorId(Integer id) {
        return repository.findById(id);
    }
}