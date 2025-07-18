package com.back.hostely.model;

import com.back.hostely.enums.TaskEstado;
import com.back.hostely.enums.Prioridad;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tasks_id")
    private Integer id;

    @Column(name = "tasks_nombre", length = 255)
    private String nombre;

    @Column(name = "tasks_descripcion", length = 255)
    private String descripcion;

    @Column(name = "tasks_fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "tasks_fecha_fin")
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "tasks_estado", nullable = false)
    private TaskEstado estado = TaskEstado.PENDIENTE;

    @Enumerated(EnumType.STRING)
    @Column(name = "tasks_prioridad", nullable = false)
    private Prioridad prioridad = Prioridad.NONE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasks_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasks_recurrente_id")
    private TaskRecurrente tareaRecurrente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasks_sede", nullable = false)
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasks_negocio", nullable = false)
    private Negocio negocio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tasks_created_by", nullable = false)
    private Usuario creadoPor;

    @CreationTimestamp
    @Column(name = "tasks_created_at", updatable = false)
    private LocalDateTime creadoEn;

    @UpdateTimestamp
    @Column(name = "tasks_updated_at")
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TaskEstado getEstado() {
        return estado;
    }

    public void setEstado(TaskEstado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TaskRecurrente getTareaRecurrente() {
        return tareaRecurrente;
    }

    public void setTareaRecurrente(TaskRecurrente tareaRecurrente) {
        this.tareaRecurrente = tareaRecurrente;
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
}