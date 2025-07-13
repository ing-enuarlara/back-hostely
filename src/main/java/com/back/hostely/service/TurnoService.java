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
import java.sql.Timestamp;
import java.time.LocalDate;

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

    public boolean hayConflictoHorarioEditar(Date fecha, Time inicio, Time fin, Integer usuarioId, Integer turnoId) {
        return !turnoRepository.verificarConflictosEdit(fecha, inicio, fin, usuarioId, turnoId).isEmpty();
    }

    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    // public void actualizarEstadoSiCoincideConFichaje(Integer usuarioId, Timestamp fechaHoraFichaje, String tipoFichaje) {
    //     Date fecha = Date.valueOf(fechaHoraFichaje.toLocalDateTime().toLocalDate());
    //     Time hora = Time.valueOf(fechaHoraFichaje.toLocalDateTime().toLocalTime());

    //     List<Turno> turnosDelDia = turnoRepository.findByUsuarioIdAndFecha(usuarioId, fecha);

    //     for (Turno turno : turnosDelDia) {
    //         if (!turno.getEstado().equals(TurnoEstado.ASIGNADO)) continue;

    //         if (!hora.before(turno.getInicio()) && !hora.after(turno.getFin())) {
    //             if ("ENTRADA".equalsIgnoreCase(tipoFichaje)) {
    //                 turno.setEstado(TurnoEstado.EN_CURSO);
    //             } else if ("SALIDA".equalsIgnoreCase(tipoFichaje)) {
    //                 turno.setEstado(TurnoEstado.FINALIZADO);
    //             }
    //             turnoRepository.save(turno);
    //             break;
    //         }
    //     }
    // }

    public void actualizarEstadoSiCoincideConFichaje(Integer usuarioId, Timestamp fechaHoraFichaje, String tipoFichaje) {
        LocalDate fecha = fechaHoraFichaje.toLocalDateTime().toLocalDate();
        Date fechaSql = Date.valueOf(fecha);

        List<Turno> turnosDelDia = turnoRepository.findByUsuarioIdAndFecha(usuarioId, fechaSql);

        for (Turno turno : turnosDelDia) {
            // Verificamos según el tipo de fichaje
            if ("ENTRADA".equalsIgnoreCase(tipoFichaje) && turno.getEstado() == TurnoEstado.ASIGNADO) {
                turno.setEstado(TurnoEstado.EN_CURSO);
                turnoRepository.save(turno);
                break;
            }

            if ("SALIDA".equalsIgnoreCase(tipoFichaje) && turno.getEstado() == TurnoEstado.EN_CURSO) {
                turno.setEstado(TurnoEstado.FINALIZADO);
                turnoRepository.save(turno);
                break;
            }
        }
    }
}