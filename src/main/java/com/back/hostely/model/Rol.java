package com.back.hostely.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "rol_nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "rol_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "rol_created_at", insertable = false, updatable = false)
    private String creadoEn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rol_permisos", joinColumns = @JoinColumn(name = "rope_rol"), inverseJoinColumns = @JoinColumn(name = "rope_permiso"))
    private Set<Permiso> permisos = new HashSet<>();

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }
}