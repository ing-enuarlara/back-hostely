package com.back.hostely.dto;

import java.util.List;

public class EmpleadoListDTO {
    // Campos de Usuario
    private Integer id;
    private String nombre;
    private String email;
    private Integer edad;
    private String direccion;
    private String estadoSocial;
    private String passwordHash;
    private String telefono;
    private String fotoPerfil;
    private Integer paisId;
    private Integer negocioId;
    private String creadoEn;

    // Campos de UsuarioEmpleado
    private String disponibilidad;
    private String estado;
    private String transportePropio;

    private List<RolDTO> roles;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEstadoSocial() { return estadoSocial; }
    public void setEstadoSocial(String estadoSocial) { this.estadoSocial = estadoSocial; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public Integer getPaisId() { return paisId; }
    public void setPaisId(Integer paisId) { this.paisId = paisId; }

    public Integer getNegocioId() { return negocioId; }
    public void setNegocioId(Integer negocioId) { this.negocioId = negocioId; }

    public String getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getTransportePropio() { return transportePropio; }
    public void setTransportePropio(String transportePropio) { this.transportePropio = transportePropio; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }

    public List<RolDTO> getRoles() { return roles; }
    public void setRoles(List<RolDTO> roles) { this.roles = roles; }
}