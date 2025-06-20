package com.back.hostely.service;

import com.back.hostely.model.TaskRecurrente;
import com.back.hostely.repository.TaskRecurrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskRecurrenteService {

    @Autowired
    private TaskRecurrenteRepository repository;

    public List<TaskRecurrente> buscarTodos() {
        return repository.findAll();
    }

    public Optional<TaskRecurrente> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<TaskRecurrente> buscarActivas() {
        return repository.findByEstado(com.back.hostely.enums.TaskRecurrenteEstado.ACTIVO);
    }

    public List<TaskRecurrente> buscarVigentesHoy(LocalDate hoy) {
        return repository.findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(hoy, hoy);
    }

    public TaskRecurrente guardar(TaskRecurrente tarea) {
        return repository.save(tarea);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}