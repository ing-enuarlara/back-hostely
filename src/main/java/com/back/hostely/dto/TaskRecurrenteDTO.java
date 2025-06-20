package com.back.hostely.dto;

import com.back.hostely.enums.TaskRecurrenteEstado;
import com.back.hostely.enums.TaskRecurrenteFrecuencia;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskRecurrenteDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private TaskRecurrenteFrecuencia frecuencia;
    private String diaSemana; // solo para semanal
    private LocalTime hora;
    private TaskRecurrenteEstado estado;
    private Integer usuarioId;
    private Integer sedeId;
    private Integer negocioId;
    private Integer creadoPorId;

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
    public TaskRecurrenteEstado getEstado() {
        return estado;
    }
    public void setEstado(TaskRecurrenteEstado estado) {
        this.estado = estado;
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

    // Getters y setters completos (puedo generarlos si lo pides)
}