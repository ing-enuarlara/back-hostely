package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "permisos_dependencias")
public class PermisoDependencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pede_id", insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pede_permiso", nullable = false)
    private Permiso permiso;

    @ManyToOne
    @JoinColumn(name = "pede_depende", nullable = false)
    private Permiso dependeDe;

    @Column(name = "pede_created_at", insertable = false, updatable = false)
    private String creadoEn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Permiso getPermiso() { return permiso; }
    public void setPermiso(Permiso permiso) { this.permiso = permiso; }

    public Permiso getDependeDe() { return dependeDe; }
    public void setDependeDe(Permiso dependeDe) { this.dependeDe = dependeDe; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}