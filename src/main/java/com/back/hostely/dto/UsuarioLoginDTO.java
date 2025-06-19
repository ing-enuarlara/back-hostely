package com.back.hostely.dto;

public class UsuarioLoginDTO {
    private Integer id;
    private String nombre;
    private String email;
    private String fotoPerfil;
    private Integer negocioId;
    private String verificado;
    
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFotoPerfil() {
        return fotoPerfil;
    }
    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
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
}