package com.back.hostely.dto;

import com.back.hostely.model.Sede;

public class SedeDTO {
    private Integer id;
    private String nombre;
    private String direccion;

    public SedeDTO() {}

    public SedeDTO(Integer id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public SedeDTO(Sede s) {
        this.id = s.getId();
        this.nombre = s.getNombre();
        this.direccion = s.getDireccion();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}