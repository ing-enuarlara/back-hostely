package com.back.hostely.repository;

import com.back.hostely.model.Turno;
import com.back.hostely.enums.TurnoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {

	List<Turno> findByFecha(Date fecha);

	List<Turno> findByInicio(Time inicio);

	List<Turno> findByFin(Time fin);

	List<Turno> findByEstado(TurnoEstado estado);

	@Query("SELECT t FROM Turno t WHERE t.puesto.id = :puestoId")
	List<Turno> findByPuestoId(@Param("puestoId") Integer puestoId);

	@Query("SELECT t FROM Turno t WHERE t.usuario.id = :usuarioId")
	List<Turno> findByUsuarioId(@Param("usuarioId") Integer usuarioId);

	@Query("SELECT t FROM Turno t WHERE t.sede.id = :sedeId")
	List<Turno> findBySedeId(@Param("sedeId") Integer sedeId);

	@Query("SELECT t FROM Turno t WHERE t.negocio.id = :negocioId")
	List<Turno> findByNegocioId(@Param("negocioId") Integer negocioId);

	@Query("SELECT t FROM Turno t WHERE t.creadoPor.id = :creadorId")
	List<Turno> findByCreadoPorId(@Param("creadorId") Integer creadorId);

	@Query("SELECT t FROM Turno t WHERE t.fecha = :fecha AND t.usuario.id = :usuarioId AND " +
		"((:inicio BETWEEN t.inicio AND t.fin) OR (:fin BETWEEN t.inicio AND t.fin) OR " +
		"(t.inicio BETWEEN :inicio AND :fin))")
	List<Turno> verificarConflictos(Date fecha, Time inicio, Time fin, Integer usuarioId);

	@Query("SELECT t FROM Turno t WHERE t.fecha = :fecha AND t.usuario.id = :usuarioId AND t.puesto.id = :puestoId AND t.id <> :turnoId AND " +
		"((:inicio BETWEEN t.inicio AND t.fin) OR (:fin BETWEEN t.inicio AND t.fin) OR " +
		"(t.inicio BETWEEN :inicio AND :fin))")
	List<Turno> verificarConflictosEdit(Date fecha, Time inicio, Time fin, Integer usuarioId, Integer puestoId, Integer turnoId);

	@Query("SELECT t FROM Turno t WHERE t.usuario.id = :usuarioId AND t.fecha = :fecha")
	List<Turno> findByUsuarioIdAndFecha(@Param("usuarioId") Integer usuarioId, @Param("fecha") Date fecha);

	@Query("SELECT t FROM Turno t " +
		"WHERE t.negocio.id = :negocioId " +
		"AND t.fecha BETWEEN :inicio AND :fin " +
		"AND (:sedeId IS NULL OR t.sede.id = :sedeId) " +
		"AND (:puestoId IS NULL OR t.puesto.id = :puestoId) " +
		"AND (:usuarioId IS NULL OR t.usuario.id = :usuarioId)")
	List<Turno> findByNegocioYFechas(@Param("negocioId") Integer negocioId, @Param("sedeId") Integer sedeId, @Param("puestoId") Integer puestoId, @Param("usuarioId") Integer usuarioId, @Param("inicio") Date inicio, @Param("fin") Date fin);
}