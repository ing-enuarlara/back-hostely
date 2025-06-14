package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario_sede")
public class InventarioSede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inse_id")
    private Integer id;

    @Column(name = "inse_insumo")
    private Integer insumoId;

    @Column(name = "inse_sede")
    private Integer sedeId;

    @Column(name = "inse_stock_actual")
    private Double stockActual;

    @Column(name = "inse_creado_en")
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getInsumoId() { return insumoId; }
    public void setInsumoId(Integer insumoId) { this.insumoId = insumoId; }

    public Integer getSedeId() { return sedeId; }
    public void setSedeId(Integer sedeId) { this.sedeId = sedeId; }

    public Double getStockActual() { return stockActual; }
    public void setStockActual(Double stockActual) { this.stockActual = stockActual; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}