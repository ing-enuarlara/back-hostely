package com.back.hostely.service;

import com.back.hostely.model.Producto;
import com.back.hostely.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Producto> buscarPorNegocio(Integer negocioId) {
        return repository.findByNegocioId(negocioId);
    }

    public Producto crear(Producto p) {
        return repository.save(p);
    }

    public Producto actualizar(Integer id, Producto datos) {
        return repository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setDescripcion(datos.getDescripcion());
            p.setPrecioVenta(datos.getPrecioVenta());
            p.setNegocioId(datos.getNegocioId());
            return repository.save(p);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}