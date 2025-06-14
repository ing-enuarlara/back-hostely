package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_negocios")
public class TipoNegocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tine_id")
    private Integer id;

    @Column(name = "tine_nombre", nullable = false)
    private String nombre;

    @Column(name = "tine_descripcion")
    private String descripcion;

    @Column(name = "tine_creado_en")
    private String creadoEn;

    // Getters y Setters
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

    public String getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }
}