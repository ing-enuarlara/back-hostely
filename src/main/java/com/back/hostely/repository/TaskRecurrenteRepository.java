package com.back.hostely.repository;

import com.back.hostely.model.TaskRecurrente;
import com.back.hostely.enums.Estado;
import com.back.hostely.enums.TaskRecurrenteFrecuencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRecurrenteRepository extends JpaRepository<TaskRecurrente, Integer> {

    List<TaskRecurrente> findByEstado(Estado estado);

    List<TaskRecurrente> findByFrecuencia(TaskRecurrenteFrecuencia frecuencia);

    List<TaskRecurrente> findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(LocalDate hoy1, LocalDate hoy2);
}