package com.back.hostely.dto;

import com.back.hostely.enums.Estado;
import com.back.hostely.enums.TaskRecurrenteFrecuencia;
import com.back.hostely.model.TaskRecurrente; // Add this import or update the package as needed
import com.back.hostely.enums.Prioridad;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskRecurrenteDTOResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private TaskRecurrenteFrecuencia frecuencia;
    private String diaSemana;
    private LocalTime hora;
    private Estado estado;
    private Prioridad prioridad;
    private Integer usuarioId;
    private Integer sedeId;
    private Integer negocioId;
    private Integer creadoPorId;

    public TaskRecurrenteDTOResponse(TaskRecurrente tarea) {
        this.id = tarea.getId();
        this.nombre = tarea.getNombre();
        this.descripcion = tarea.getDescripcion();
        this.fechaInicio = tarea.getFechaInicio();
        this.fechaFin = tarea.getFechaFin();
        this.frecuencia = tarea.getFrecuencia();
        this.diaSemana = tarea.getDiaSemana();
        this.hora = tarea.getHora();
        this.estado = tarea.getEstado();
        this.prioridad = tarea.getPrioridad();
        this.usuarioId = tarea.getUsuario().getId();
        this.sedeId = tarea.getSede().getId();
        this.negocioId = tarea.getNegocio().getId();
        this.creadoPorId = tarea.getCreadoPor().getId();
    }

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

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getSedeId() {
        return sedeId;
    }

    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
    }

    public Integer getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(Integer negocioId) {
        this.negocioId = negocioId;
    }

    public Integer getCreadoPorId() {
        return creadoPorId;
    }

    public void setCreadoPorId(Integer creadoPorId) {
        this.creadoPorId = creadoPorId;
    }
}