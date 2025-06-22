package com.back.hostely.service;

import com.back.hostely.enums.TaskEstado;
import com.back.hostely.model.Task;
import com.back.hostely.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> buscarTodos() {
        return taskRepository.findAll();
    }

    public Optional<Task> buscarPorId(Integer id) {
        return taskRepository.findById(id);
    }

    public List<Task> buscarPorFechaInicio(LocalDateTime fechaInicio) {
        return taskRepository.findByFechaInicio(fechaInicio);
    }

    public List<Task> buscarPorFechaFin(LocalDateTime fechaFin) {
        return taskRepository.findByFechaFin(fechaFin);
    }

    public List<Task> buscarPorEstado(TaskEstado estado) {
        return taskRepository.findByEstado(estado);
    }

    public List<Task> buscarPorUsuario(Integer usuarioId) {
        return taskRepository.findByUsuarioId(usuarioId);
    }

    public List<Task> buscarPorSede(Integer sedeId) {
        return taskRepository.findBySedeId(sedeId);
    }

    public List<Task> buscarPorNegocio(Integer negocioId) {
        return taskRepository.findByNegocioId(negocioId);
    }

    public List<Task> buscarPorCreador(Integer usuarioId) {
        return taskRepository.findByCreadoPorId(usuarioId);
    }

    public boolean hayConflicto(LocalDateTime fechaInicio, LocalDateTime fechaFin, Integer usuarioId) {
        return !taskRepository.verificarConflictos(fechaInicio, fechaFin, usuarioId).isEmpty();
    }

    public boolean hayConflictoEditar(LocalDateTime fechaInicio, LocalDateTime fechaFin, Integer usuarioId, Integer taskId) {
        return !taskRepository.verificarConflictosEdit(fechaInicio, fechaFin, usuarioId, taskId).isEmpty();
    }

    public Task guardar(Task task) {
        return taskRepository.save(task);
    }

    public void eliminar(Integer id) {
        taskRepository.deleteById(id);
    }
}