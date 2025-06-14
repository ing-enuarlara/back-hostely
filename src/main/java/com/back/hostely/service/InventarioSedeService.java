package com.back.hostely.service;

import com.back.hostely.model.InventarioSede;
import com.back.hostely.repository.InventarioSedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioSedeService {

    @Autowired
    private InventarioSedeRepository repository;

    public List<InventarioSede> listarTodos() {
        return repository.findAll();
    }

    public Optional<InventarioSede> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<InventarioSede> buscarPorSede(Integer sedeId) {
        return repository.findBySedeId(sedeId);
    }

    public List<InventarioSede> buscarPorInsumo(Integer insumoId) {
        return repository.findByInsumoId(insumoId);
    }

    public InventarioSede crear(InventarioSede registro) {
        return repository.save(registro);
    }

    public InventarioSede actualizar(Integer id, InventarioSede datos) {
        return repository.findById(id).map(r -> {
            r.setInsumoId(datos.getInsumoId());
            r.setSedeId(datos.getSedeId());
            r.setStockActual(datos.getStockActual());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}