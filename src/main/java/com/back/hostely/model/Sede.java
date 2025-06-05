package com.back.hostely.model;

import jakarta.persistence.*;
// import java.util.*;

@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String direccion;

    // @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Usuario> usuarios = new ArrayList<>();

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    // public List<Usuario> getUsuarios() { return usuarios; }
    // public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
}