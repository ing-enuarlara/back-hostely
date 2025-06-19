package com.back.hostely.controller;

import com.back.hostely.dto.TurnoDTO;
import com.back.hostely.dto.TurnoListadoDTO;
import com.back.hostely.enums.TurnoEstado;
import com.back.hostely.model.Negocio;
import com.back.hostely.model.Sede;
import com.back.hostely.model.Turno;
import com.back.hostely.model.Usuario;
import com.back.hostely.service.NegocioService;
import com.back.hostely.service.SedeService;
import com.back.hostely.service.TurnoService;
import com.back.hostely.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private NegocioService negocioService;

    @GetMapping
    public List<Turno> listarTodos() {
        return turnoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> obtenerTurno(@PathVariable Integer id) {
        Optional<Turno> optTurno = turnoService.buscarPorId(id);

        if (optTurno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Turno turno = optTurno.get();
        TurnoDTO dto = new TurnoDTO();

        dto.setId(turno.getId());
        dto.setUsuarioId(turno.getUsuario().getId());
        dto.setSedeId(turno.getSede().getId());
        dto.setNegocioId(turno.getNegocio().getId());
        dto.setFecha(turno.getFecha());
        dto.setInicio(turno.getInicio());
        dto.setFin(turno.getFin());
        dto.setEstado(turno.getEstado());
        dto.setDescripcion(turno.getDescripcion());
        dto.setCreadoPorId(turno.getCreadoPor().getId());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Turno> buscarPorFecha(@PathVariable Date fecha) {
        return turnoService.buscarPorFecha(fecha);
    }

    @GetMapping("/hora/{inicio}")
    public List<Turno> buscarPorInicio(@PathVariable Time inicio) {
        return turnoService.buscarPorInicio(inicio);
    }

    @GetMapping("/hora/{fin}")
    public List<Turno> buscarPorFin(@PathVariable Time fin) {
        return turnoService.buscarPorFin(fin);
    }

    @GetMapping("/estado/{estado}")
    public List<Turno> buscarPorEstado(@PathVariable TurnoEstado estado) {
        return turnoService.buscarPorEstado(estado);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Turno> buscarPorUsuario(@PathVariable Integer usuarioId) {
        return turnoService.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/sede/{sedeId}")
    public List<TurnoListadoDTO> listarPorSede(@PathVariable Integer sedeId) {
        return turnoService.buscarPorSede(sedeId).stream()
                .map(TurnoListadoDTO::new)
                .toList();
    }

    @GetMapping("/negocio/{negocioId}")
    public List<TurnoListadoDTO> listarPorNegocio(@PathVariable Integer negocioId) {
        return turnoService.buscarPorNegocio(negocioId).stream()
                .map(TurnoListadoDTO::new)
                .toList();
    }

    @GetMapping("/creadoPor/{usuarioId}")
    public List<Turno> buscarPorCreador(@PathVariable Integer usuarioId) {
        return turnoService.buscarPorCreador(usuarioId);
    }

    @PostMapping
    public ResponseEntity<?> crearTurno(@Valid @RequestBody TurnoDTO dto) {
        if (turnoService.hayConflictoHorario(dto.getFecha(), dto.getInicio(), dto.getFin(), dto.getUsuarioId())) {
            return ResponseEntity.badRequest().body("Ya existe un turno para ese usuario en ese horario.");
        }

        Turno turno = new Turno();
        turno.setFecha(dto.getFecha());
        turno.setInicio(dto.getInicio());
        turno.setFin(dto.getFin());
        turno.setEstado(dto.getEstado() != null ? dto.getEstado() : TurnoEstado.ASIGNADO);
        turno.setDescripcion(dto.getDescripcion());

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(dto.getUsuarioId());
        Optional<Sede> sedeOpt = sedeService.buscarPorId(dto.getSedeId());
        Optional<Negocio> negocioOpt = negocioService.buscarPorId(dto.getNegocioId());
        Optional<Usuario> creadorOpt = usuarioService.buscarPorId(dto.getCreadoPorId());

        if (usuarioOpt.isEmpty() || sedeOpt.isEmpty() || negocioOpt.isEmpty() || creadorOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        turno.setUsuario(usuarioOpt.get());
        turno.setSede(sedeOpt.get());
        turno.setNegocio(negocioOpt.get());
        turno.setCreadoPor(creadorOpt.get());

        Turno guardado = turnoService.guardar(turno);
        TurnoDTO respuesta = new TurnoDTO();
        respuesta.setId(guardado.getId());
        respuesta.setFecha(guardado.getFecha());
        respuesta.setInicio(guardado.getInicio());
        respuesta.setFin(guardado.getFin());
        respuesta.setEstado(guardado.getEstado());
        respuesta.setUsuarioId(dto.getUsuarioId());
        respuesta.setSedeId(dto.getSedeId());
        respuesta.setNegocioId(dto.getNegocioId());
        respuesta.setDescripcion(dto.getDescripcion());
        respuesta.setCreadoPorId(dto.getCreadoPorId());

        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody TurnoDTO dto) {
        Optional<Turno> optTurno = turnoService.buscarPorId(id);
        if (optTurno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Validar existencia de entidades relacionadas
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(dto.getUsuarioId());
        Optional<Sede> sedeOpt = sedeService.buscarPorId(dto.getSedeId());

        if (usuarioOpt.isEmpty() || sedeOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Alguna entidad relacionada no existe.");
        }

        // Verificar conflicto de horario
        if (turnoService.hayConflictoHorarioEditar(dto.getFecha(), dto.getInicio(), dto.getFin(), dto.getUsuarioId(),
                dto.getId())) {
            return ResponseEntity.badRequest().body("Conflicto de horario detectado.");
        }

        // Actualizar los campos
        Turno turno = optTurno.get();
        turno.setFecha(dto.getFecha());
        turno.setInicio(dto.getInicio());
        turno.setFin(dto.getFin());
        turno.setEstado(turno.getEstado());
        turno.setUsuario(usuarioOpt.get());
        turno.setSede(sedeOpt.get());
        turno.setDescripcion(dto.getDescripcion());

        Turno actualizado = turnoService.guardar(turno);

        TurnoDTO respuesta = new TurnoDTO();
        respuesta.setId(actualizado.getId());
        respuesta.setFecha(actualizado.getFecha());
        respuesta.setInicio(actualizado.getInicio());
        respuesta.setFin(actualizado.getFin());
        respuesta.setEstado(actualizado.getEstado());
        respuesta.setUsuarioId(actualizado.getUsuario().getId());
        respuesta.setSedeId(actualizado.getSede().getId());
        respuesta.setNegocioId(actualizado.getNegocio() != null ? actualizado.getNegocio().getId() : null);
        respuesta.setDescripcion(actualizado.getDescripcion());
        respuesta.setCreadoPorId(actualizado.getCreadoPor() != null ? actualizado.getCreadoPor().getId() : null);

        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (turnoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        turnoService.eliminar(id);
        return ResponseEntity.ok("Turno eliminado");
    }
}