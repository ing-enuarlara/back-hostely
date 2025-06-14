package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sede_id")
    private Integer id;

    @Column(name = "sede_nombre", nullable = false)
    private String nombre;

    @Column(name = "sede_direccion")
    private String direccion;

    @Column(name = "sede_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "sede_ingreso")
    private String ingreso;

    @Column(name = "sede_creado_en")
    private String creadoEn;

    // Getters y Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public String getIngreso() { return ingreso; }
    public void setIngreso(String ingreso) { this.ingreso = ingreso; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}