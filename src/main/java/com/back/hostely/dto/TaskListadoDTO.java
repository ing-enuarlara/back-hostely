package com.back.hostely.dto;

import com.back.hostely.enums.TaskEstado;
import com.back.hostely.enums.Prioridad;

import java.time.LocalDateTime;

public class TaskListadoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private TaskEstado estado;
    private Prioridad prioridad;
    private String usuarioNombre;
    private String usuarioFoto;
    private Integer usuarioRolId;
    private String usuarioRolNombre;
    private Integer tareaRecurrenteId;
    private String creadorNombre;
    private String creadorFoto;
    private Integer creadorRolId;
    private String creadorRolNombre;
    private LocalDateTime creadoEn;

    public TaskListadoDTO() {
    }

    public TaskListadoDTO(com.back.hostely.model.Task task) {
        this.id = task.getId();
        this.nombre = task.getNombre();
        this.descripcion = task.getDescripcion();
        this.fechaInicio = task.getFechaInicio();
        this.fechaFin = task.getFechaFin();
        this.estado = task.getEstado();
        this.prioridad = task.getPrioridad();
        this.tareaRecurrenteId = task.getTareaRecurrente() != null ? task.getTareaRecurrente().getId() : null;
        this.creadoEn = task.getCreadoEn();

        if (task.getUsuario() != null) {
            this.usuarioNombre = task.getUsuario().getNombre();
            this.usuarioFoto = task.getUsuario().getFotoPerfil();
            if (task.getUsuario().getRolPrincipal() != null) {
                this.usuarioRolId = task.getUsuario().getRolPrincipal().getId();
                this.usuarioRolNombre = task.getUsuario().getRolPrincipal().getNombre();
            }
        }

        if (task.getCreadoPor() != null) {
            this.creadorNombre = task.getCreadoPor().getNombre();
            this.creadorFoto = task.getCreadoPor().getFotoPerfil();
            if (task.getCreadoPor().getRolPrincipal() != null) {
                this.creadorRolId = task.getCreadoPor().getRolPrincipal().getId();
                this.creadorRolNombre = task.getCreadoPor().getRolPrincipal().getNombre();
            }
        }
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

    public Integer getTareaRecurrenteId() {
        return tareaRecurrenteId;
    }

    public void setTareaRecurrenteId(Integer tareaRecurrenteId) {
        this.tareaRecurrenteId = tareaRecurrenteId;
    }

    public String getCreadorNombre() {
        return creadorNombre;
    }

    public void setCreadorNombre(String creadorNombre) {
        this.creadorNombre = creadorNombre;
    }

    public String getCreadorFoto() {
        return creadorFoto;
    }

    public void setCreadorFoto(String creadorFoto) {
        this.creadorFoto = creadorFoto;
    }

    public Integer getCreadorRolId() {
        return creadorRolId;
    }

    public void setCreadorRolId(Integer creadorRolId) {
        this.creadorRolId = creadorRolId;
    }

    public String getCreadorRolNombre() {
        return creadorRolNombre;
    }

    public void setCreadorRolNombre(String creadorRolNombre) {
        this.creadorRolNombre = creadorRolNombre;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}