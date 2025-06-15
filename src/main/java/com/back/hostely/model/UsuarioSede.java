package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_sedes")
public class UsuarioSede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usse_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "usse_uss")
    private Integer usuarioId;

    @Column(name = "usse_sede")
    private Integer sedeId;

    @Column(name = "usse_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public Integer getSedeId() { return sedeId; }
    public void setSedeId(Integer sedeId) { this.sedeId = sedeId; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}