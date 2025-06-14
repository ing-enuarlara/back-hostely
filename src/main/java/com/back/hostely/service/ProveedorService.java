package com.back.hostely.service;

import com.back.hostely.model.Proveedor;
import com.back.hostely.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    public List<Proveedor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Proveedor> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Proveedor> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public Proveedor crear(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public Proveedor actualizar(Integer id, Proveedor datos) {
        return repository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setEmail(datos.getEmail());
            p.setTelefono(datos.getTelefono());
            p.setDireccion(datos.getDireccion());
            return repository.save(p);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}