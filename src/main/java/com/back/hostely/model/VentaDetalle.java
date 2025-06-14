package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "venta_detalle")
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vede_id")
    private Integer id;

    @Column(name = "vede_venta")
    private Integer ventaId;

    @Column(name = "vede_producto")
    private Integer productoId;

    @Column(name = "vede_cantidad")
    private Integer cantidad;

    @Column(name = "vede_creado_en")
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getVentaId() { return ventaId; }
    public void setVentaId(Integer ventaId) { this.ventaId = ventaId; }

    public Integer getProductoId() { return productoId; }
    public void setProductoId(Integer productoId) { this.productoId = productoId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}