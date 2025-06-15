package com.back.hostely.service;

import com.back.hostely.model.NegocioProveedor;
import com.back.hostely.repository.NegocioProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NegocioProveedorService {

    @Autowired
    private NegocioProveedorRepository repository;

    public List<NegocioProveedor> listarTodos() {
        return repository.findAll();
    }

    public Optional<NegocioProveedor> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<NegocioProveedor> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public List<NegocioProveedor> buscarPorProveedor(Integer proveedorId) {
        return repository.findByProveedorId(proveedorId);
    }

    public NegocioProveedor crear(NegocioProveedor d) {
        return repository.save(d);
    }

    public NegocioProveedor actualizar(Integer id, NegocioProveedor datos) {
        return repository.findById(id).map(det -> {
            det.setNegocioId(datos.getNegocioId());
            det.setProveedorId(datos.getProveedorId());
            return repository.save(det);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}