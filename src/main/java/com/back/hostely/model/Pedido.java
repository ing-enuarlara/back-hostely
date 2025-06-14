package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedi_id")
    private Integer id;

    @Column(name = "pedi_sede")
    private Integer sedeId;

    @Column(name = "pedi_proveedor")
    private Integer proveedorId;

    @Column(name = "pedi_fecha_creacion")
    private String fechaCreacion;

    @Column(name = "pedi_estado")
    private String estado;

    @Column(name = "pedi_enviado")
    private Boolean enviado;

    @Column(name = "pedi_creado_en")
    private String creadoEn;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getSedeId() { return sedeId; }
    public void setSedeId(Integer sedeId) { this.sedeId = sedeId; }

    public Integer getProveedorId() { return proveedorId; }
    public void setProveedorId(Integer proveedorId) { this.proveedorId = proveedorId; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Boolean getEnviado() { return enviado; }
    public void setEnviado(Boolean enviado) { this.enviado = enviado; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}