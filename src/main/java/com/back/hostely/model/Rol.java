package com.back.hostely.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
// import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;

    @Column(name = "rol_nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "rol_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "rol_creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    // @OneToMany(mappedBy = "rol")
    // private List<UsuarioRol> usuarios;

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

    // public List<UsuarioRol> getUsuarios() {
    //     return usuarios;
    // }

    // public void setUsuarios(List<UsuarioRol> usuarios) {
    //     this.usuarios = usuarios;
    // }
}