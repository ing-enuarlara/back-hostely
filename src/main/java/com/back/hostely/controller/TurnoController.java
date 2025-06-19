package com.back.hostely.controller;

import com.back.hostely.dto.TurnoDTO;
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
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return turnoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
    public List<Turno> buscarPorSede(@PathVariable Integer sedeId) {
        return turnoService.buscarPorSede(sedeId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Turno> buscarPorNegocio(@PathVariable Integer negocioId) {
        return turnoService.buscarPorNegocio(negocioId);
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

        return ResponseEntity.ok(turnoService.guardar(turno));
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
        Optional<Negocio> negocioOpt = negocioService.buscarPorId(dto.getNegocioId());
        Optional<Usuario> creadorOpt = usuarioService.buscarPorId(dto.getCreadoPorId());

        if (usuarioOpt.isEmpty() || sedeOpt.isEmpty() || negocioOpt.isEmpty() || creadorOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Alguna entidad relacionada no existe.");
        }

        // Verificar conflicto de horario
        if (turnoService.hayConflictoHorario(dto.getFecha(), dto.getInicio(), dto.getFin(), dto.getUsuarioId())) {
            return ResponseEntity.badRequest().body("Conflicto de horario detectado.");
        }

        // Actualizar los campos
        Turno turno = optTurno.get();
        turno.setFecha(dto.getFecha());
        turno.setInicio(dto.getInicio());
        turno.setFin(dto.getFin());
        turno.setEstado(dto.getEstado());
        turno.setUsuario(usuarioOpt.get());
        turno.setSede(sedeOpt.get());
        turno.setNegocio(negocioOpt.get());
        turno.setDescripcion(dto.getDescripcion());
        turno.setCreadoPor(creadorOpt.get());

        return ResponseEntity.ok(turnoService.guardar(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (turnoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        turnoService.eliminar(id);
        return ResponseEntity.ok("Turno eliminado");
    }
}