package com.back.hostely.dto;

public class EmpleadoDTO {
    // Campos de Usuario
    private String nombre;
    private String email;
    private Integer edad;
    private String direccion;
    private String estadoSocial;
    private String passwordHash;
    private String telefono;
    private Integer paisId;
    private Integer negocioId;

    // Campos de UsuarioEmpleado
    private String disponibilidad;
    private String estado;
    private String transportePropio;

    // Getters y Setters
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
}