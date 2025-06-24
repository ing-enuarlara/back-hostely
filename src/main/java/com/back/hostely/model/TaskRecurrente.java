package com.back.hostely.model;

import com.back.hostely.enums.TaskRecurrenteFrecuencia;
import com.back.hostely.enums.Estado;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_recurrentes")
public class TaskRecurrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tare_id")
    private Integer id;

    @Column(name = "tare_nombre", nullable = false)
    private String nombre;

    @Column(name = "tare_descripcion")
    private String descripcion;

    @Column(name = "tare_fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "tare_fecha_fin")
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "tare_frecuencia", nullable = false)
    private TaskRecurrenteFrecuencia frecuencia;

    @Column(name = "tare_dia_semana")
    private String diaSemana; // Valida solo si frecuencia = SEMANAL

    @Column(name = "tare_hora")
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    @Column(name = "tare_estado", nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tare_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tare_sede", nullable = false)
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tare_negocio", nullable = false)
    private Negocio negocio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tare_created_by", nullable = false)
    private Usuario creadoPor;

    @CreationTimestamp
    @Column(name = "tare_created_at", updatable = false)
    private LocalDateTime creadoEn;

    @UpdateTimestamp
    @Column(name = "tare_updated_at")
    private LocalDateTime actualizadoEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TaskRecurrenteFrecuencia getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(TaskRecurrenteFrecuencia frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    // Getters y setters completos (puedo generarlos si los necesitas ahora)
}