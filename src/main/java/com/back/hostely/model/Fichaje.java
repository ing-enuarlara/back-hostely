package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fichaje")
public class Fichaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fich_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "fich_usuario", nullable = false)
    private Integer usuarioId;

    @Column(name = "fich_sede", nullable = false)
    private Integer sedeId;

    @Column(name = "fich_tipo", nullable = false)
    private String tipo; // ENTRADA o SALIDA

    @Column(name = "fich_fecha")
    private String fecha;

    @Column(name = "fich_observaciones")
    private String observaciones;

    @Column(name = "fich_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public Integer getSedeId() { return sedeId; }
    public void setSedeId(Integer sedeId) { this.sedeId = sedeId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}