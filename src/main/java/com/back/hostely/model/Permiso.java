package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "per_nombre", nullable = false)
    private String nombre;

    @Column(name = "per_descripcion", insertable = false)
    private String descripcion;

    @Column(name = "per_padre", insertable = false)
    private Integer padre;

    @Column(name = "per_created_at", insertable = false, updatable = false)
    private String creadoEn;

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

    public String getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }
}