package com.back.hostely.controller;

import com.back.hostely.dto.TaskDTO;
import com.back.hostely.enums.TaskEstado;
import com.back.hostely.model.Negocio;
import com.back.hostely.model.Sede;
import com.back.hostely.model.Task;
import com.back.hostely.model.Usuario;
import com.back.hostely.service.NegocioService;
import com.back.hostely.service.SedeService;
import com.back.hostely.service.TaskService;
import com.back.hostely.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private NegocioService negocioService;

    @GetMapping
    public List<Task> listarTodos() {
        return taskService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return taskService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fecha/{fechaInicio}")
    public List<Task> buscarPorFechaInicio(@PathVariable LocalDateTime fechaInicio) {
        return taskService.buscarPorFechaInicio(fechaInicio);
    }

    @GetMapping("/fecha/{fechaFin}")
    public List<Task> buscarPorFechaFin(@PathVariable LocalDateTime fechaFin) {
        return taskService.buscarPorFechaFin(fechaFin);
    }

    @GetMapping("/estado/{estado}")
    public List<Task> buscarPorEstado(@PathVariable TaskEstado estado) {
        return taskService.buscarPorEstado(estado);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Task> buscarPorUsuario(@PathVariable Integer usuarioId) {
        return taskService.buscarPorUsuario(usuarioId);
    }

    @GetMapping("/sede/{sedeId}")
    public List<Task> buscarPorSede(@PathVariable Integer sedeId) {
        return taskService.buscarPorSede(sedeId);
    }

    @GetMapping("/negocio/{negocioId}")
    public List<Task> buscarPorNegocio(@PathVariable Integer negocioId) {
        return taskService.buscarPorNegocio(negocioId);
    }

    @GetMapping("/creadoPor/{usuarioId}")
    public List<Task> buscarPorCreador(@PathVariable Integer usuarioId) {
        return taskService.buscarPorCreador(usuarioId);
    }

    @PostMapping
    public ResponseEntity<?> crearTask(@Valid @RequestBody TaskDTO dto) {
        if (taskService.hayConflictoHorario(dto.getFechaInicio(), dto.getFechaFin(), dto.getUsuarioId())) {
            return ResponseEntity.badRequest().body("Ya existe un Task para ese usuario en ese horario.");
        }

        Task Task = new Task();
        Task.setFechaInicio(dto.getFechaInicio());
        Task.setFechaFin(dto.getFechaFin());
        Task.setEstado(dto.getEstado() != null ? dto.getEstado() : TaskEstado.PENDIENTE);
        Task.setDescripcion(dto.getDescripcion());

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(dto.getUsuarioId());
        Optional<Sede> sedeOpt = sedeService.buscarPorId(dto.getSedeId());
        Optional<Negocio> negocioOpt = negocioService.buscarPorId(dto.getNegocioId());
        Optional<Usuario> creadorOpt = usuarioService.buscarPorId(dto.getCreadoPorId());

        if (usuarioOpt.isEmpty() || sedeOpt.isEmpty() || negocioOpt.isEmpty() || creadorOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task.setUsuario(usuarioOpt.get());
        Task.setSede(sedeOpt.get());
        Task.setNegocio(negocioOpt.get());
        Task.setCreadoPor(creadorOpt.get());

        return ResponseEntity.ok(taskService.guardar(Task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @Valid @RequestBody TaskDTO dto) {
        Optional<Task> optTask = taskService.buscarPorId(id);
        if (optTask.isEmpty()) {
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
        if (taskService.hayConflictoHorario(dto.getFechaInicio(), dto.getFechaFin(), dto.getUsuarioId())) {
            return ResponseEntity.badRequest().body("Conflicto de horario detectado.");
        }

        // Actualizar los campos
        Task Task = optTask.get();
        Task.setFechaInicio(dto.getFechaInicio());
        Task.setFechaFin(dto.getFechaFin());
        Task.setEstado(dto.getEstado());
        Task.setUsuario(usuarioOpt.get());
        Task.setSede(sedeOpt.get());
        Task.setNegocio(negocioOpt.get());
        Task.setDescripcion(dto.getDescripcion());
        Task.setCreadoPor(creadorOpt.get());

        return ResponseEntity.ok(taskService.guardar(Task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (taskService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        taskService.eliminar(id);
        return ResponseEntity.ok("Task eliminado");
    }
}