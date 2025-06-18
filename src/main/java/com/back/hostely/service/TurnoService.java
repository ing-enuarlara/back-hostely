package com.back.hostely.service;

import com.back.hostely.enums.TurnoEstado;
import com.back.hostely.model.Turno;
import com.back.hostely.repository.TurnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> buscarPorId(Integer id) {
        return turnoRepository.findById(id);
    }

    public List<Turno> buscarPorFecha(Date fecha) {
        return turnoRepository.findByFecha(fecha);
    }

    public List<Turno> buscarPorInicio(Time inicio) {
        return turnoRepository.findByInicio(inicio);
    }

    public List<Turno> buscarPorFin(Time fin) {
        return turnoRepository.findByFin(fin);
    }

    public List<Turno> buscarPorEstado(TurnoEstado estado) {
        return turnoRepository.findByEstado(estado);
    }

    public List<Turno> buscarPorUsuario(Integer usuarioId) {
        return turnoRepository.findByUsuarioId(usuarioId);
    }

    public List<Turno> buscarPorSede(Integer sedeId) {
        return turnoRepository.findBySedeId(sedeId);
    }

    public List<Turno> buscarPorNegocio(Integer negocioId) {
        return turnoRepository.findByNegocioId(negocioId);
    }

    public List<Turno> buscarPorCreador(Integer usuarioId) {
        return turnoRepository.findByCreadoPorId(usuarioId);
    }

    public boolean hayConflictoHorario(Date fecha, Time inicio, Time fin, Integer usuarioId) {
        return !turnoRepository.verificarConflictos(fecha, inicio, fin, usuarioId).isEmpty();
    }

    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }
}