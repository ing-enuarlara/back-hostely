package com.back.hostely.model;

import com.back.hostely.enums.Estado;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tpv")
public class TPV implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpv_id")
    private Long id;

    @Column(name = "tpv_nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tpv_sede")
    private Sede sede;

    @Column(name = "tpv_clave_acceso", unique = true)
    private String claveAcceso;

    @Enumerated(EnumType.STRING)
    @Column(name = "tpv_activa", nullable = false)
    private Estado activa;

    @CreationTimestamp
    @Column(name = "tpv_created_at", updatable = false)
    private LocalDateTime creadoEn;

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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public Estado getActiva() {
        return activa;
    }

    public void setActiva(Estado activa) {
        this.activa = activa;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}