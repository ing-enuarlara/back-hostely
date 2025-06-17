package com.back.hostely.service;

import com.back.hostely.model.Fichaje;
import com.back.hostely.repository.FichajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichajeService {

    @Autowired
    private FichajeRepository repository;

    public List<Fichaje> listarTodos() {
        return repository.findAll();
    }

    public Optional<Fichaje> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Fichaje> buscarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<Fichaje> buscarPorPuesto(Integer puestoId) {
        return repository.findByPuestoId(puestoId);
    }

    public List<Fichaje> buscarPorSede(Integer sedeId) {
        return repository.findBySedeId(sedeId);
    }

    public List<Fichaje> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Optional<Fichaje> buscarPorEnlace(String enlace) {
        return repository.findByFichEnlace(enlace);
    }

    public Fichaje registrar(Fichaje fichaje) {
        return repository.save(fichaje);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}