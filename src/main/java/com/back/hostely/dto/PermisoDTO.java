package com.back.hostely.dto;

public class PermisoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer padre;

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
    public Integer getPadre() {
        return padre;
    }
    public void setPadre(Integer padre) {
        this.padre = padre;
    }
}