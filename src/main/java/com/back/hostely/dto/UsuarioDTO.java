package com.back.hostely.dto;

import com.back.hostely.model.Usuario;

public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String foto;

    public UsuarioDTO(Usuario u) {
        this.id = u.getId();
        this.nombre = u.getNombre();
        this.foto = u.getFotoPerfil();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFotoPerfil() {
        return foto;
    }
}