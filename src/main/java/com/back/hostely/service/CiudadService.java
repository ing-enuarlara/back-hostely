package com.back.hostely.service;

import com.back.hostely.model.Ciudad;
import com.back.hostely.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> obtenerTodas() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> obtenerPorId(Integer id) {
        return ciudadRepository.findById(id);
    }
}