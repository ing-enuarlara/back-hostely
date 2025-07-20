package com.back.hostely.service;

import com.back.hostely.model.FuncionFichaje;
import com.back.hostely.model.FuncionPuesto;
import com.back.hostely.model.Fichaje;
import com.back.hostely.repository.FichajeRepository;
import com.back.hostely.repository.FuncionPuestoRepository;
import com.back.hostely.repository.FuncionFichajeRepository;
import com.back.hostely.enums.EstadoFuncion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

@Service
public class FuncionFichajeService {
    @Autowired
    private FuncionFichajeRepository repo;

    @Autowired
    private FuncionPuestoRepository puestoRepo;

    @Autowired
    private FichajeRepository fichajeRepo;

    public void generarPorFichaje(Integer puestoId, Integer fichajeId, LocalDate fecha) {
        List<FuncionPuesto> funciones = puestoRepo.findByPuestoId(puestoId);
        Fichaje fichaje = fichajeRepo.findById(fichajeId)
            .orElseThrow(() -> new RuntimeException("Fichaje no encontrado"));

        for (FuncionPuesto f : funciones) {
            FuncionFichaje nueva = new FuncionFichaje();
            nueva.setFecha(fecha);
            nueva.setTime(f.getTime());
            nueva.setFuncion(f);
            nueva.setFichaje(fichaje);
            nueva.setEstado(EstadoFuncion.PENDIENTE);
            repo.save(nueva);
        }
    }

    public List<FuncionFichaje> listarPorFichaje(Integer fichajeId) {
        return repo.findByFichajeId(fichajeId);
    }
}