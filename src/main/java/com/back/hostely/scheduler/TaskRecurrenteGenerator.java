package com.back.hostely.scheduler;

import com.back.hostely.enums.TaskEstado;
import com.back.hostely.model.Task;
import com.back.hostely.model.TaskRecurrente;
import com.back.hostely.repository.TaskRepository;
import com.back.hostely.service.TaskRecurrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
// import jakarta.annotation.PostConstruct;

import java.time.*;
import java.util.List;

@Component
public class TaskRecurrenteGenerator {

    @Autowired
    private TaskRecurrenteService recurrenteService;

    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(cron = "0 0 0 * * *") // Todos los días a las 00:00
    public void generarTareasDeHoy() {
        LocalDate hoy = LocalDate.now();
        DayOfWeek diaSemana = hoy.getDayOfWeek(); // LUNES, MARTES, etc.

        List<TaskRecurrente> recurrentes = recurrenteService.buscarVigentesHoy(hoy);

        for (TaskRecurrente tarea : recurrentes) {
            boolean esHoy = switch (tarea.getFrecuencia()) {
                case DIARIA -> true;
                case SEMANAL -> tarea.getDiaSemana() != null &&
                        tarea.getDiaSemana().equalsIgnoreCase(diaSemana.name());
                case MENSUAL -> hoy.getDayOfMonth() == tarea.getFechaInicio().getDayOfMonth();
                case ANUAL -> hoy.getDayOfYear() == tarea.getFechaInicio().getDayOfYear();
            };

            if (!esHoy)
                continue;

            LocalDateTime inicio = tarea.getHora() != null
                    ? LocalDateTime.of(hoy, tarea.getHora())
                    : LocalDateTime.of(hoy, LocalTime.of(9, 0)); // default 09:00

            LocalDateTime fin = inicio.plusHours(1); // default 1h duración

            Task nueva = new Task();
            nueva.setNombre(tarea.getNombre());
            nueva.setDescripcion(tarea.getDescripcion());
            nueva.setFechaInicio(inicio);
            nueva.setFechaFin(fin);
            nueva.setEstado(TaskEstado.PENDIENTE);
            nueva.setUsuario(tarea.getUsuario());
            nueva.setSede(tarea.getSede());
            nueva.setNegocio(tarea.getNegocio());
            nueva.setCreadoPor(tarea.getCreadoPor());
            nueva.setTareaRecurrente(tarea);

            taskRepository.save(nueva);
        }
    }

    // @PostConstruct
    // public void testManual() {
    //     generarTareasDeHoy(); // solo durante pruebas
    // }
}