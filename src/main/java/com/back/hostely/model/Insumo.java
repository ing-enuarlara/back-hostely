package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "insumos")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private Integer id;

    @Column(name = "ins_nombre", nullable = false)
    private String nombre;

    @Column(name = "ins_unidad_medida")
    private String unidadMedida;

    @Column(name = "ins_stock_minimo")
    private Double stockMinimo;

    @Column(name = "ins_proveedor")
    private Integer proveedorId;

    @Column(name = "ins_precio_unitario")
    private Double precioUnitario;

    @Column(name = "ins_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "ins_creado_en")
    private String creadoEn;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public Double getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Double stockMinimo) { this.stockMinimo = stockMinimo; }

    public Integer getProveedorId() { return proveedorId; }
    public void setProveedorId(Integer proveedorId) { this.proveedorId = proveedorId; }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}