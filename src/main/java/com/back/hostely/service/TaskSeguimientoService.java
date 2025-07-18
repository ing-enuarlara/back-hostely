package com.back.hostely.service;

import com.back.hostely.model.Task;
import com.back.hostely.model.TaskSeguimiento;
import com.back.hostely.model.Usuario;
import com.back.hostely.repository.TaskSeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskSeguimientoService {

    @Autowired
    private TaskSeguimientoRepository repository;

    public TaskSeguimiento guardar(String descripcion, String adjunto, Task task, Usuario creadoPor) {
        TaskSeguimiento seguimiento = new TaskSeguimiento();
        seguimiento.setDescripcion(descripcion);
        seguimiento.setAdjunto(adjunto);
        seguimiento.setTask(task);
        seguimiento.setCreadoPor(creadoPor);
        return repository.save(seguimiento);
    }

    public List<TaskSeguimiento> listarPorTask(Integer taskId) {
        return repository.findByTaskIdOrderByCreadoEnAsc(taskId);
    }
}