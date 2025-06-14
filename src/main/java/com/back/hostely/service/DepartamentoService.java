package com.back.hostely.service;

import com.back.hostely.model.Departamento;
import com.back.hostely.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> obtenerPorId(Integer id) {
        return departamentoRepository.findById(id);
    }
}