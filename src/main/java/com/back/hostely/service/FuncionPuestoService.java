package com.back.hostely.service;

import com.back.hostely.model.FuncionPuesto;
import com.back.hostely.repository.FuncionPuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionPuestoService {
    @Autowired
    private FuncionPuestoRepository repo;

    public FuncionPuesto buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Función no encontrada"));
    }

    public List<FuncionPuesto> listarPorPuesto(Integer puestoId) {
        return repo.findByPuestoId(puestoId);
    }

    public FuncionPuesto guardar(FuncionPuesto funcion) {
        return repo.save(funcion);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}