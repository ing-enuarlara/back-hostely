package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_empleado")
public class UsuarioEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usem_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "usem_uss")
    private Integer usuarioId;

    @Column(name = "usem_disponibilidad")
    private String disponibilidad;

    @Column(name = "usem_estado")
    private String estado;

    @Column(name = "usem_transporte_propio")
    private String transportePropio;

    @Column(name = "usem_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getTransportePropio() { return transportePropio; }
    public void setTransportePropio(String transportePropio) { this.transportePropio = transportePropio; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}