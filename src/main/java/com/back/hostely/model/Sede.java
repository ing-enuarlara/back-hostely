package com.back.hostely.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
// import java.util.List;

@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sede_id")
    private Long id;

    @Column(name = "sede_nombre", nullable = false)
    private String nombre;

    @Column(name = "sede_direccion")
    private String direccion;

    @Column(name = "sede_negocio", nullable = false)
    private Integer negocioId;

    @Column(name = "sede_ingreso", nullable = false)
    @Enumerated(EnumType.STRING)
    private IngresoTipo ingreso;

    @Column(name = "sede_creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    // @OneToMany(mappedBy = "sede")
    // private List<UsuarioSede> usuarios;

    public enum IngresoTipo {
        EMPLEADO, SEDE
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(Integer negocioId) {
        this.negocioId = negocioId;
    }

    public IngresoTipo getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoTipo ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    // public List<UsuarioSede> getUsuarios() {
    //     return usuarios;
    // }

    // public void setUsuarios(List<UsuarioSede> usuarios) {
    //     this.usuarios = usuarios;
    // }
}