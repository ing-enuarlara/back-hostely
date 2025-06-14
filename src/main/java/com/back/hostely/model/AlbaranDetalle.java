package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "albaran_detalle")
public class AlbaranDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alde_id")
    private Integer id;

    @Column(name = "alde_albaran")
    private Integer albaranId;

    @Column(name = "alde_insumo")
    private Integer insumoId;

    @Column(name = "alde_cantidad")
    private Double cantidad;

    @Column(name = "alde_creado_en")
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAlbaranId() { return albaranId; }
    public void setAlbaranId(Integer albaranId) { this.albaranId = albaranId; }

    public Integer getInsumoId() { return insumoId; }
    public void setInsumoId(Integer insumoId) { this.insumoId = insumoId; }

    public Double getCantidad() { return cantidad; }
    public void setCantidad(Double cantidad) { this.cantidad = cantidad; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}