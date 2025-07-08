package com.back.hostely.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back.hostely.model.Usuario;

public class UsuarioRequestDTO {
    private Integer id;
    private String nombre;
    private String foto;
    private Integer edad;
    private String email;
    private Integer paisId;
    private String direccion;
    private String telefono;
    private String estadoSocial;
    private String passwordHash;
    private Integer negocioId;
    private String verificado;

    private List<Integer> roles;
    private List<Integer> sedes;

    public UsuarioRequestDTO() {}

    public UsuarioRequestDTO(Usuario u) {
        this.id = u.getId();
        this.nombre = u.getNombre();
        this.foto = u.getFotoPerfil();
        this.edad = u.getEdad();
        this.email = u.getEmail();
        this.paisId = u.getPaisId();
        this.direccion = u.getDireccion();
        this.telefono = u.getTelefono();
        this.estadoSocial = u.getEstadoSocial();
        this.negocioId = u.getNegocioId();
        this.verificado = u.getVerificado();

        this.roles = u.getRoles() != null
            ? u.getRoles().stream().map(r -> r.getId()).collect(Collectors.toList())
            : List.of();

        this.sedes = u.getSedes() != null
            ? u.getSedes().stream().map(s -> s.getId()).collect(Collectors.toList())
            : List.of();
    }

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

    public String getFotoPerfil() {
        return foto;
    }

    public void setFotoPerfil(String foto) {
        this.foto = foto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstadoSocial() {
        return estadoSocial;
    }

    public void setEstadoSocial(String estadoSocial) {
        this.estadoSocial = estadoSocial;
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

    public String getVerificado() {
        return verificado;
    }

    public void setVerificado(String verificado) {
        this.verificado = verificado;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public List<Integer> getSedes() {
        return sedes;
    }

    public void setSedes(List<Integer> sedes) {
        this.sedes = sedes;
    }
}