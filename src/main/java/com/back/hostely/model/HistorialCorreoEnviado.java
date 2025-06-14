package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_correos_enviados")
public class HistorialCorreoEnviado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hisco_id")
    private Integer id;

    @Column(name = "hisco_fecha")
    private String fecha;

    @Column(name = "hisco_remitente")
    private Integer remitenteId;

    @Column(name = "hisco_destinatario")
    private Integer destinatarioId;

    @Column(name = "hisco_asunto")
    private String asunto;

    @Column(name = "hisco_contenido")
    private String contenido;

    @Column(name = "hisco_adjunto")
    private Boolean adjunto;

    @Column(name = "hisco_archivo_salida")
    private String archivoSalida;

    @Column(name = "hisco_estado")
    private String estado;

    @Column(name = "hisco_descripcion_error")
    private String descripcionError;

    @Column(name = "hisco_negocio")
    private Integer negocioId;

    @Column(name = "hisco_creado_en")
    private String creadoEn;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Integer remitenteId) {
        this.remitenteId = remitenteId;
    }

    public Integer getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Integer destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(Boolean adjunto) {
        this.adjunto = adjunto;
    }

    public String getArchivoSalida() {
        return archivoSalida;
    }

    public void setArchivoSalida(String archivoSalida) {
        this.archivoSalida = archivoSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public Integer getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(Integer negocioId) {
        this.negocioId = negocioId;
    }

    public String getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }
}