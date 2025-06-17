package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "puestos")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pues_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "pues_nombre", nullable = false)
    private String nombre;

    @Column(name = "pues_descripcion")
    private String descripcion;

    @Column(name = "pues_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "pues_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}