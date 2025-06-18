package com.back.hostely.repository;

import com.back.hostely.model.Task;
import com.back.hostely.enums.TaskEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByFechaInicio(LocalDateTime fechaInicio);

    List<Task> findByFechaFin(LocalDateTime fechaFin);

    List<Task> findByEstado(TaskEstado estado);

    @Query("SELECT t FROM Task t WHERE t.usuario.id = :usuarioId")
    List<Task> findByUsuarioId(@Param("usuarioId") Integer usuarioId);

    @Query("SELECT t FROM Task t WHERE t.sede.id = :sedeId")
    List<Task> findBySedeId(@Param("sedeId") Integer sedeId);

    @Query("SELECT t FROM Task t WHERE t.negocio.id = :negocioId")
    List<Task> findByNegocioId(@Param("negocioId") Integer negocioId);

    @Query("SELECT t FROM Task t WHERE t.creadoPor.id = :creadorId")
    List<Task> findByCreadoPorId(@Param("creadorId") Integer creadorId);

    @Query("SELECT t FROM Task t WHERE t.usuario.id = :usuarioId AND " +
            "((:inicio BETWEEN t.fechaInicio AND t.fechaFin) OR (:fin BETWEEN t.fechaInicio AND t.fechaFin) OR " +
            "(t.fechaInicio BETWEEN :inicio AND :fin))")
    List<Task> verificarConflictos(@Param("inicio") LocalDateTime fechaInicio, @Param("fin") LocalDateTime fechaFin, @Param("usuarioId") Integer usuarioId);
}