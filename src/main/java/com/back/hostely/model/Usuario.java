package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uss_id")
    private Integer id;

    @Column(name = "uss_nombre", nullable = false)
    private String nombre;

    @Column(name = "uss_email", nullable = false, unique = true)
    private String email;

    @Column(name = "uss_pais", nullable = false)
    private Integer paisId;

    @Column(name = "uss_telefono")
    private String telefono;

    @Column(name = "uss_password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "uss_negocio")
    private Integer negocioId;

    @Column(name = "uss_creado_en")
    private String creadoEn;

    // Getters y Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getPaisId() { return paisId; }
    public void setPaisId(Integer paisId) { this.paisId = paisId; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}