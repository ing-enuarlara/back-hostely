package com.back.hostely.dto;

import com.back.hostely.model.TaskSeguimiento;

import java.time.LocalDateTime;

public class TaskSeguimientoDTO {
    private Integer id;
    private String descripcion;
    private String adjunto;
    private LocalDateTime creadoEn;
    private String creadoPorNombre;
    private String creadoPorFoto;

    public TaskSeguimientoDTO(TaskSeguimiento s) {
        this.id = s.getId();
        this.descripcion = s.getDescripcion();
        this.adjunto = s.getAdjunto();
        this.creadoEn = s.getCreadoEn();
        this.creadoPorNombre = s.getCreadoPor().getNombre();
        this.creadoPorFoto = s.getCreadoPor().getFotoPerfil();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getCreadoPorNombre() {
        return creadoPorNombre;
    }

    public void setCreadoPorNombre(String creadoPorNombre) {
        this.creadoPorNombre = creadoPorNombre;
    }

    public String getCreadoPorFoto() {
        return creadoPorFoto;
    }

    public void setCreadoPorFoto(String creadoPorFoto) {
        this.creadoPorFoto = creadoPorFoto;
    }

}