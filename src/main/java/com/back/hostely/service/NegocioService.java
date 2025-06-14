package com.back.hostely.service;

import com.back.hostely.model.Negocio;
import com.back.hostely.repository.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NegocioService {

    @Autowired
    private NegocioRepository repository;

    public List<Negocio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Negocio> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Negocio> buscarPorNombre(String nombre) {
        return repository.findByRazonSocialContainingIgnoreCase(nombre);
    }

    public List<Negocio> buscarPorPais(Integer paisId) {
        return repository.findByPais(paisId);
    }

    public List<Negocio> buscarPorTipo(Integer tipoId) {
        return repository.findByTipo(tipoId);
    }

    public Negocio crear(Negocio negocio) {
        return repository.save(negocio);
    }

    public Negocio actualizar(Integer id, Negocio datos) {
        return repository.findById(id).map(n -> {
            n.setEmail(datos.getEmail());
            n.setTipo(datos.getTipo());
            n.setRazonSocial(datos.getRazonSocial());
            n.setNumEmpleados(datos.getNumEmpleados());
            n.setPais(datos.getPais());
            n.setTelefono(datos.getTelefono());
            n.setDireccion(datos.getDireccion());
            n.setUssAdmin(datos.getUssAdmin());
            return repository.save(n);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}