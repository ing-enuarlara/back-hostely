package com.back.hostely.service;

import com.back.hostely.model.HorarioPuesto;
import com.back.hostely.repository.HorarioPuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioPuestoService {
    @Autowired
    private HorarioPuestoRepository repo;

    public HorarioPuesto buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Función no encontrada"));
    }

    public List<HorarioPuesto> listarPorPuesto(Integer puestoId) {
        return repo.findByPuestoId(puestoId);
    }

    public HorarioPuesto guardar(HorarioPuesto funcion) {
        return repo.save(funcion);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}