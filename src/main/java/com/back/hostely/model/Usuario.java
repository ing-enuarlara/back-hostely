package com.back.hostely.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uss_id")
    private Long id;

    @Column(name = "uss_nombre", nullable = false)
    private String nombre;

    @Column(name = "uss_email", nullable = false, unique = true)
    private String email;

    @Column(name = "uss_pais")
    private Integer paisId;

    @Column(name = "uss_telefono")
    private Integer telefono;

    @Column(name = "uss_password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "uss_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "uss_creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioRol> roles;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioSede> sedes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Integer getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(Integer negocioId) {
        this.negocioId = negocioId;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public List<UsuarioRol> getRoles() {
        return roles;
    }

    public void setRoles(List<UsuarioRol> roles) {
        this.roles = roles;
    }

    public List<UsuarioSede> getSedes() {
        return sedes;
    }

    public void setSedes(List<UsuarioSede> sedes) {
        this.sedes = sedes;
    }
}