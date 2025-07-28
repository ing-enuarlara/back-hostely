package com.back.hostely.service;

import com.back.hostely.dto.HorarioDTO;
import com.back.hostely.dto.PlanningDTO;
import com.back.hostely.dto.PuestoPlanningDTO;
import com.back.hostely.dto.TurnoSemanalDTO;
import com.back.hostely.enums.TurnoEstado;
import com.back.hostely.model.Puesto;
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
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@Transactional
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PuestoService puestoService;

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

    public List<Turno> buscarPorPuesto(Integer puestoId) {
        return turnoRepository.findByPuestoId(puestoId);
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

    public boolean hayConflictoHorarioEditar(Date fecha, Time inicio, Time fin, Integer usuarioId, Integer puestoId, Integer turnoId) {
        return !turnoRepository.verificarConflictosEdit(fecha, inicio, fin, usuarioId, puestoId, turnoId).isEmpty();
    }

    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    public PlanningDTO obtenerPlanningSemana(Integer negocioId, Integer sedeId, Integer puestoId, Integer usuarioId) {
        LocalDate hoy = LocalDate.now();
        LocalDate lunes = hoy.with(DayOfWeek.MONDAY);
        LocalDate domingo = lunes.plusDays(6);

        List<Turno> turnosSemana = turnoRepository.findByNegocioYFechas(negocioId, sedeId, puestoId, usuarioId, Date.valueOf(lunes), Date.valueOf(domingo));

        if (sedeId != null && sedeId > 0) {
            turnosSemana = turnosSemana.stream()
                .filter(t -> t.getSede().getId().equals(sedeId))
                .toList();
        }

        if (puestoId != null && puestoId > 0) {
            turnosSemana = turnosSemana.stream()
                .filter(t -> t.getPuesto().getId().equals(puestoId))
                .toList();
        }

        if (usuarioId != null && usuarioId > 0) {
            turnosSemana = turnosSemana.stream()
                .filter(t -> t.getUsuario().getId().equals(usuarioId))
                .toList();
        }

        List<Puesto> puestos = puestoService.buscarPorNegocio(negocioId);
        if (puestoId != null && puestoId > 0) {
            puestos = puestos.stream().filter(p -> p.getId().equals(puestoId)).toList();
        }

        List<PuestoPlanningDTO> puestosDTO = puestos.stream().map(p -> {
            PuestoPlanningDTO dto = new PuestoPlanningDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setHorarios(p.getHorarios().stream().map(h -> {
                HorarioDTO hdto = new HorarioDTO();
                hdto.setId(h.getId());
                hdto.setInicio(h.getTimeInicio().toString());
                hdto.setFin(h.getTimeFin().toString());
                return hdto;
            }).toList());
            return dto;
        }).toList();

        List<TurnoSemanalDTO> turnosDTO = turnosSemana.stream().map(t -> {
            TurnoSemanalDTO dto = new TurnoSemanalDTO();
            dto.setId(t.getId());
            dto.setSedeId(t.getSede().getId());
            dto.setSedeNombre(t.getSede().getNombre());
            dto.setPuestoId(t.getPuesto().getId());
            dto.setPuestoNombre(t.getPuesto().getNombre());
            dto.setUsuarioId(t.getUsuario().getId());
            dto.setUsuarioNombre(t.getUsuario().getNombre());
            dto.setFecha(t.getFecha().toString());
            dto.setInicio(t.getInicio().toString());
            dto.setFin(t.getFin().toString());
            dto.setEstado(t.getEstado().name());
            return dto;
        }).toList();

        PlanningDTO planning = new PlanningDTO();
        planning.setPuestos(puestosDTO);
        planning.setTurnos(turnosDTO);
        return planning;
    }

    public void actualizarEstadoSiCoincideConFichaje(Integer usuarioId, Timestamp fechaHoraFichaje, String tipoFichaje) {
        LocalDate fecha = fechaHoraFichaje.toLocalDateTime().toLocalDate();
        Date fechaSql = Date.valueOf(fecha);

        List<Turno> turnosDelDia = turnoRepository.findByUsuarioIdAndFecha(usuarioId, fechaSql);

        for (Turno turno : turnosDelDia) {
            // Verificamos según el tipo de fichaje
            if ("ENTRADA".equalsIgnoreCase(tipoFichaje) && (turno.getEstado() == TurnoEstado.ASIGNADO || turno.getEstado() == TurnoEstado.RETRASO)) {
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