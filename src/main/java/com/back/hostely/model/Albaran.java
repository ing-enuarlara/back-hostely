package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "albaranes")
public class Albaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alb_id")
    private Integer id;

    @Column(name = "alb_sede")
    private Integer sedeId;

    @Column(name = "alb_fecha")
    private String fecha;

    @Column(name = "alb_usuario")
    private Integer usuarioId;

    @Column(name = "alb_observaciones")
    private String observaciones;

    @Column(name = "alb_creado_en")
    private String creadoEn;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getSedeId() { return sedeId; }
    public void setSedeId(Integer sedeId) { this.sedeId = sedeId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}