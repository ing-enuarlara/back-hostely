package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "negocio_proveedores")
public class NegocioProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nepr_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "nepr_negocio")
    private Integer negocioId;

    @Column(name = "nepr_proveedor")
    private Integer proveedorId;

    @Column(name = "nepr_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public Integer getProveedorId() { return proveedorId; }
    public void setProveedorId(Integer proveedorId) { this.proveedorId = proveedorId; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}