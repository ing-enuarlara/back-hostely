package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recetas")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rece_id")
    private Integer id;

    @Column(name = "rece_producto")
    private Integer productoId;

    @Column(name = "rece_insumo")
    private Integer insumoId;

    @Column(name = "rece_cantidad_requerida")
    private Double cantidadRequerida;

    @Column(name = "rece_creado_en")
    private String creadoEn;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }

    public Integer getInsumoId() { return insumoId; }
    public void setInsumoId(Integer insumoId) { this.insumoId = insumoId; }

    public Double getCantidadRequerida() { return cantidadRequerida; }
    public void setCantidadRequerida(Double cantidadRequerida) { this.cantidadRequerida = cantidadRequerida; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}