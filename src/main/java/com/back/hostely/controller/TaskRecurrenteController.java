package com.back.hostely.controller;

import com.back.hostely.dto.TaskRecurrenteDTO;
import com.back.hostely.dto.TaskRecurrenteDTOResponse;
import com.back.hostely.enums.TaskRecurrenteEstado;
import com.back.hostely.model.*;
import com.back.hostely.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks-recurrentes")
public class TaskRecurrenteController {

    @Autowired
    private TaskRecurrenteService taskRecurrenteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private NegocioService negocioService;

    @GetMapping
    public List<TaskRecurrente> listarTodos() {
        return taskRecurrenteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        return taskRecurrenteService.buscarPorId(id)
                .map(t -> ResponseEntity.ok(new TaskRecurrenteDTOResponse(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/activas")
    public List<TaskRecurrente> listarActivas() {
        return taskRecurrenteService.buscarActivas();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TaskRecurrenteDTO dto) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(dto.getUsuarioId());
        Optional<Sede> sede = sedeService.buscarPorId(dto.getSedeId());
        Optional<Negocio> negocio = negocioService.buscarPorId(dto.getNegocioId());
        Optional<Usuario> creador = usuarioService.buscarPorId(dto.getCreadoPorId());

        if (usuario.isEmpty() || sede.isEmpty() || negocio.isEmpty() || creador.isEmpty()) {
            return ResponseEntity.badRequest().body("Alguna entidad relacionada no existe.");
        }

        TaskRecurrente tarea = new TaskRecurrente();
        tarea.setNombre(dto.getNombre());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaInicio(dto.getFechaInicio());
        tarea.setFechaFin(dto.getFechaFin());
        tarea.setFrecuencia(dto.getFrecuencia());
        tarea.setDiaSemana(dto.getDiaSemana());
        tarea.setHora(dto.getHora());
        tarea.setEstado(dto.getEstado() != null ? dto.getEstado() : TaskRecurrenteEstado.ACTIVO);
        tarea.setUsuario(usuario.get());
        tarea.setSede(sede.get());
        tarea.setNegocio(negocio.get());
        tarea.setCreadoPor(creador.get());

        TaskRecurrente tareaGuardada = taskRecurrenteService.guardar(tarea);

        return ResponseEntity.ok(new TaskRecurrenteDTOResponse(tareaGuardada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody TaskRecurrenteDTO dto) {
        Optional<TaskRecurrente> opt = taskRecurrenteService.buscarPorId(id);

        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        TaskRecurrente tarea = opt.get();

        Optional<Usuario> usuario = usuarioService.buscarPorId(dto.getUsuarioId());
        Optional<Sede> sede = sedeService.buscarPorId(dto.getSedeId());

        if (usuario.isEmpty() || sede.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario o sede no existen.");
        }

        tarea.setNombre(dto.getNombre());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaInicio(dto.getFechaInicio());
        tarea.setFechaFin(dto.getFechaFin());
        tarea.setFrecuencia(dto.getFrecuencia());
        tarea.setDiaSemana(dto.getDiaSemana());
        tarea.setHora(dto.getHora());
        tarea.setEstado(dto.getEstado() != null ? dto.getEstado() : tarea.getEstado());
        tarea.setUsuario(usuario.get());
        tarea.setSede(sede.get());

        TaskRecurrente actualizada = taskRecurrenteService.guardar(tarea);

        return ResponseEntity.ok(new TaskRecurrenteDTOResponse(actualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (taskRecurrenteService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        taskRecurrenteService.eliminar(id);
        return ResponseEntity.ok("Tarea recurrente eliminada.");
    }
}