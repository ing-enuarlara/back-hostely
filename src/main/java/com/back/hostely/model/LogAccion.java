package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "log_acciones")
public class LogAccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "log_usuario")
    private Integer usuarioId;

    @Column(name = "log_accion")
    private String accion;

    @Column(name = "log_fecha")
    private String fecha;

    @Column(name = "log_datos_anteriores")
    private String datosAnteriores;

    @Column(name = "log_datos_nuevos")
    private String datosNuevos;

    @Column(name = "log_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getDatosAnteriores() { return datosAnteriores; }
    public void setDatosAnteriores(String datosAnteriores) { this.datosAnteriores = datosAnteriores; }

    public String getDatosNuevos() { return datosNuevos; }
    public void setDatosNuevos(String datosNuevos) { this.datosNuevos = datosNuevos; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}