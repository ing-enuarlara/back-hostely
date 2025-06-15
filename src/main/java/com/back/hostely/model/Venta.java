package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vent_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "vent_sede")
    private Integer sedeId;

    @Column(name = "vent_fecha")
    private String fecha;

    @Column(name = "vent_total")
    private Double total;

    @Column(name = "vent_usuario")
    private Integer usuarioId;

    @Column(name = "vent_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getSedeId() { return sedeId; }
    public void setSedeId(Integer sedeId) { this.sedeId = sedeId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}