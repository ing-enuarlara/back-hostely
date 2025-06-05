package com.back.hostely.service;

import com.back.hostely.model.Sede;
import com.back.hostely.repository.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    private final SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public List<Sede> listarTodos() {
        return sedeRepository.findAll();
    }

    public Optional<Sede> buscarPorId(Long id) {
        return sedeRepository.findById(id);
    }

    public Sede crear(Sede usuario) {
        return sedeRepository.save(usuario);
    }

    public void eliminar(Long id) {
        sedeRepository.deleteById(id);
    }
}