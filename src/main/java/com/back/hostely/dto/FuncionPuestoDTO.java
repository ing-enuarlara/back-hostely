package com.back.hostely.dto;

import java.time.LocalTime;

public class FuncionPuestoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalTime time;
    private Integer puestoId;
    private String puestoNombre;

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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(Integer puestoId) {
        this.puestoId = puestoId;
    }

    public String getPuestoNombre() {
        return puestoNombre;
    }

    public void setPuestoNombre(String puestoNombre) {
        this.puestoNombre = puestoNombre;
    }
}