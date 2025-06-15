package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reporte_errores")
public class ReporteError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rperr_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "rperr_numero")
    private String numero;

    @Column(name = "rperr_error")
    private String error;

    @Column(name = "rperr_fecha")
    private String fecha;

    @Column(name = "rperr_ip")
    private String ip;

    @Column(name = "rperr_usuario")
    private Integer usuarioId;

    @Column(name = "rperr_pagina_referencia")
    private String paginaReferencia;

    @Column(name = "rperr_pagina_actual")
    private String paginaActual;

    @Column(name = "rperr_so")
    private String sistemaOperativo;

    @Column(name = "rperr_linea")
    private String linea;

    @Column(name = "rperr_negocio")
    private Integer negocioId;

    @Column(name = "rerr_request")
    private String request;

    @Column(name = "rperr_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getPaginaReferencia() { return paginaReferencia; }
    public void setPaginaReferencia(String paginaReferencia) { this.paginaReferencia = paginaReferencia; }

    public String getPaginaActual() { return paginaActual; }
    public void setPaginaActual(String paginaActual) { this.paginaActual = paginaActual; }

    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }

    public String getLinea() { return linea; }
    public void setLinea(String linea) { this.linea = linea; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public String getRequest() { return request; }
    public void setRequest(String request) { this.request = request; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}