package com.back.hostely.repository;

import com.back.hostely.model.TaskSeguimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskSeguimientoRepository extends JpaRepository<TaskSeguimiento, Integer> {
    List<TaskSeguimiento> findByTaskIdOrderByCreadoEnAsc(Integer taskId);
}