package com.back.hostely.controller;

import com.back.hostely.dto.TaskDTO;
import com.back.hostely.dto.TaskListadoDTO;
import com.back.hostely.enums.TaskEstado;
import com.back.hostely.enums.Prioridad;
import com.back.hostely.model.Negocio;
import com.back.hostely.model.Sede;
import com.back.hostely.model.Task;
import com.back.hostely.model.TaskRecurrente;
import com.back.hostely.model.Usuario;
import com.back.hostely.service.NegocioService;
import com.back.hostely.service.SedeService;
import com.back.hostely.service.TaskService;
import com.back.hostely.service.TaskRecurrenteService;
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

    @Autowired
    private TaskRecurrenteService taskRecurrenteService;

    @GetMapping
    public List<Task> listarTodos() {
        return taskService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> obtenerTask(@PathVariable Integer id) {
        Optional<Task> optTask = taskService.buscarPorId(id);

        if (optTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optTask.get();
        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setNombre(task.getNombre());
        dto.setUsuarioId(task.getUsuario().getId());
        dto.setSedeId(task.getSede().getId());
        dto.setNegocioId(task.getNegocio().getId());
        dto.setFechaInicio(task.getFechaInicio());
        dto.setFechaFin(task.getFechaFin());
        dto.setEstado(task.getEstado());
        dto.setPrioridad(task.getPrioridad());
        dto.setDescripcion(task.getDescripcion());
        dto.setCreadoPorId(task.getCreadoPor().getId());
        dto.setTareaRecurrenteId(task.getTareaRecurrente() != null ? task.getTareaRecurrente().getId() : null);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<TaskListadoDTO> obtenerInfoTask(@PathVariable Integer id) {
        Optional<Task> optTask = taskService.buscarPorId(id);

        if (optTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        TaskListadoDTO dto = new TaskListadoDTO(optTask.get());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/fechaInicio/{fecha}")
    public List<Task> buscarPorFechaInicio(@PathVariable LocalDateTime fechaInicio) {
        return taskService.buscarPorFechaInicio(fechaInicio);
    }

    @GetMapping("/fechaFin/{fecha}")
    public List<Task> buscarPorFechaFin(@PathVariable LocalDateTime fechaFin) {
        return taskService.buscarPorFechaFin(fechaFin);
    }

    @GetMapping("/estado/{estado}")
    public List<Task> buscarPorEstado(@PathVariable TaskEstado estado) {
        return taskService.buscarPorEstado(estado);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<TaskListadoDTO> buscarPorUsuario(@PathVariable Integer usuarioId) {
        return taskService.buscarPorUsuario(usuarioId).stream()
                .map(TaskListadoDTO::new)
                .toList();
    }

    @GetMapping("/sede/{sedeId}")
    public List<TaskListadoDTO> listarPorSede(@PathVariable Integer sedeId) {
        return taskService.buscarPorSede(sedeId).stream()
                .map(TaskListadoDTO::new)
                .toList();
    }

    @GetMapping("/negocio/{negocioId}")
    public List<TaskListadoDTO> listarPorNegocio(@PathVariable Integer negocioId) {
        return taskService.buscarPorNegocio(negocioId).stream()
                .map(TaskListadoDTO::new)
                .toList();
    }

    @GetMapping("/creadoPor/{usuarioId}")
    public List<Task> buscarPorCreador(@PathVariable Integer usuarioId) {
        return taskService.buscarPorCreador(usuarioId);
    }

    @PostMapping
    public ResponseEntity<?> crearTask(@Valid @RequestBody TaskDTO dto) {
        if (taskService.hayConflicto(dto.getFechaInicio(), dto.getFechaFin(), dto.getUsuarioId())) {
            return ResponseEntity.badRequest().body("Ya existe un task para ese usuario en esa fecha.");
        }

        Task task = new Task();
        task.setFechaInicio(dto.getFechaInicio());
        task.setFechaFin(dto.getFechaFin());
        task.setEstado(dto.getEstado() != null ? dto.getEstado() : TaskEstado.PENDIENTE);
        task.setPrioridad(dto.getPrioridad() != null ? dto.getPrioridad() : Prioridad.NONE);
        task.setDescripcion(dto.getDescripcion());
        task.setNombre(dto.getNombre());

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(dto.getUsuarioId());
        Optional<Sede> sedeOpt = sedeService.buscarPorId(dto.getSedeId());
        Optional<Negocio> negocioOpt = negocioService.buscarPorId(dto.getNegocioId());
        Optional<Usuario> creadorOpt = usuarioService.buscarPorId(dto.getCreadoPorId());

        if (usuarioOpt.isEmpty() || sedeOpt.isEmpty() || negocioOpt.isEmpty() || creadorOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        task.setUsuario(usuarioOpt.get());
        task.setSede(sedeOpt.get());
        task.setNegocio(negocioOpt.get());
        task.setCreadoPor(creadorOpt.get());

        if (dto.getTareaRecurrenteId() != null) {
            Optional<TaskRecurrente> tareaRecurrenteOpt = taskRecurrenteService.buscarPorId(dto.getTareaRecurrenteId());
            tareaRecurrenteOpt.ifPresent(task::setTareaRecurrente);
        }

        Task guardado = taskService.guardar(task);

        TaskDTO respuesta = new TaskDTO();
        respuesta.setId(guardado.getId());
        respuesta.setFechaInicio(guardado.getFechaInicio());
        respuesta.setFechaFin(guardado.getFechaFin());
        respuesta.setEstado(guardado.getEstado());
        respuesta.setPrioridad(guardado.getPrioridad());
        respuesta.setUsuarioId(dto.getUsuarioId());
        respuesta.setSedeId(dto.getSedeId());
        respuesta.setNegocioId(dto.getNegocioId());
        respuesta.setDescripcion(dto.getDescripcion());
        respuesta.setCreadoPorId(dto.getCreadoPorId());
        respuesta.setNombre(dto.getNombre());

        if (guardado.getTareaRecurrente() != null) {
            respuesta.setTareaRecurrenteId(guardado.getTareaRecurrente().getId());
        }

        return ResponseEntity.ok(respuesta);
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

        if (usuarioOpt.isEmpty() || sedeOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Alguna entidad relacionada no existe.");
        }

        // Verificar conflicto de fecha
        if (taskService.hayConflictoEditar(dto.getFechaInicio(), dto.getFechaFin(), dto.getUsuarioId(), dto.getId())) {
            return ResponseEntity.badRequest().body("Conflicto de fecha detectado.");
        }

        // Actualizar los campos
        Task task = optTask.get();
        task.setFechaInicio(dto.getFechaInicio());
        task.setFechaFin(dto.getFechaFin());
        task.setEstado(task.getEstado());
        task.setPrioridad(task.getPrioridad());
        task.setUsuario(usuarioOpt.get());
        task.setSede(sedeOpt.get());
        task.setDescripcion(dto.getDescripcion());

        Task actualizado = taskService.guardar(task);

        TaskDTO respuesta = new TaskDTO();
        respuesta.setId(actualizado.getId());
        respuesta.setFechaInicio(actualizado.getFechaInicio());
        respuesta.setFechaFin(actualizado.getFechaFin());
        respuesta.setEstado(actualizado.getEstado());
        respuesta.setPrioridad(actualizado.getPrioridad());
        respuesta.setUsuarioId(actualizado.getUsuario().getId());
        respuesta.setSedeId(actualizado.getSede().getId());
        respuesta.setNegocioId(actualizado.getNegocio() != null ? actualizado.getNegocio().getId() : null);
        respuesta.setDescripcion(actualizado.getDescripcion());
        respuesta.setCreadoPorId(actualizado.getCreadoPor() != null ? actualizado.getCreadoPor().getId() : null);

        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<?> actualizarEstado(@PathVariable Integer id, @RequestBody TaskDTO dto) {
        Optional<Task> optTask = taskService.buscarPorId(id);
        if (optTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optTask.get();
        task.setEstado(dto.getEstado());

        Task actualizado = taskService.guardar(task);

        TaskDTO respuesta = new TaskDTO();
        respuesta.setId(actualizado.getId());
        respuesta.setFechaInicio(actualizado.getFechaInicio());
        respuesta.setFechaFin(actualizado.getFechaFin());
        respuesta.setEstado(actualizado.getEstado());
        respuesta.setPrioridad(actualizado.getPrioridad());
        respuesta.setUsuarioId(actualizado.getUsuario().getId());
        respuesta.setSedeId(actualizado.getSede().getId());
        respuesta.setNegocioId(actualizado.getNegocio() != null ? actualizado.getNegocio().getId() : null);
        respuesta.setDescripcion(actualizado.getDescripcion());
        respuesta.setCreadoPorId(actualizado.getCreadoPor() != null ? actualizado.getCreadoPor().getId() : null);

        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (taskService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        taskService.eliminar(id);
        return ResponseEntity.ok("Task eliminado");
    }
}