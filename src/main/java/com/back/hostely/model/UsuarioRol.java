package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_roles")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usrl_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "usrl_uss")
    private Integer usuarioId;

    @Column(name = "usrl_rol")
    private Integer rolId;

    @Column(name = "usrl_principal")
    private String principal;

    @Column(name = "usrl_created_at", insertable = false, updatable = false)
    private String creadoEn;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public Integer getRolId() { return rolId; }
    public void setRolId(Integer rolId) { this.rolId = rolId; }

    public String gePrincipal() { return principal; }
    public void sePrincipal(String principal) { this.principal = principal; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}