package com.back.hostely.dto;

import com.back.hostely.model.Rol;

import java.util.List;

public class RolDTO {
    private Integer id;
    private String nombre;
    private Integer negocioId;
    private List<Integer> permisos;

    public RolDTO() {}

    public RolDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public RolDTO(Rol r) {
        this.id = r.getId();
        this.nombre = r.getNombre();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(Integer negocioId) {
        this.negocioId = negocioId;
    }

    public List<Integer> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Integer> permisos) {
        this.permisos = permisos;
    }
}