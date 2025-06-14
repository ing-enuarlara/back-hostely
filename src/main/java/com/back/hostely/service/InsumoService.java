package com.back.hostely.service;

import com.back.hostely.model.Insumo;
import com.back.hostely.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository repository;

    public List<Insumo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Insumo> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Insumo> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Insumo> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Insumo crear(Insumo insumo) {
        return repository.save(insumo);
    }

    public Insumo actualizar(Integer id, Insumo datos) {
        return repository.findById(id).map(i -> {
            i.setNombre(datos.getNombre());
            i.setUnidadMedida(datos.getUnidadMedida());
            i.setStockMinimo(datos.getStockMinimo());
            i.setProveedorId(datos.getProveedorId());
            i.setPrecioUnitario(datos.getPrecioUnitario());
            i.setNegocioId(datos.getNegocioId());
            return repository.save(i);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}