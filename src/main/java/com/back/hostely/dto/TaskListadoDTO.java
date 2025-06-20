package com.back.hostely.dto;

import com.back.hostely.enums.TaskEstado;

import java.time.LocalDateTime;

public class TaskListadoDTO {
    private Integer id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private TaskEstado estado;
    private String usuarioNombre;
    private String usuarioFoto;
    private Integer usuarioRolId;
    private String usuarioRolNombre;
    private Integer tareaRecurrenteId;

    public TaskListadoDTO() {
    }

    public TaskListadoDTO(com.back.hostely.model.Task task) {
        this.id = task.getId();
        this.fechaInicio = task.getFechaInicio();
        this.fechaFin = task.getFechaFin();
        this.estado = task.getEstado();

        if (task.getUsuario() != null) {
            this.usuarioNombre = task.getUsuario().getNombre();
            this.usuarioFoto = task.getUsuario().getFotoPerfil();
            if (task.getUsuario().getRolPrincipal() != null) {
                this.usuarioRolId = task.getUsuario().getRolPrincipal().getId();
                this.usuarioRolNombre = task.getUsuario().getRolPrincipal().getNombre();
            }
        }
        if (task.getTareaRecurrente() != null) {
            this.tareaRecurrenteId = task.getTareaRecurrente().getId();
        }
    }

    public Integer getTareaRecurrenteId() {
        return tareaRecurrenteId;
    }

    public void setTareaRecurrenteId(Integer tareaRecurrenteId) {
        this.tareaRecurrenteId = tareaRecurrenteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioFoto() {
        return usuarioFoto;
    }

    public void setUsuarioFoto(String usuarioFoto) {
        this.usuarioFoto = usuarioFoto;
    }

    public Integer getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Integer usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public String getUsuarioRolNombre() {
        return usuarioRolNombre;
    }

    public void setUsuarioRolNombre(String usuarioRolNombre) {
        this.usuarioRolNombre = usuarioRolNombre;
    }
}