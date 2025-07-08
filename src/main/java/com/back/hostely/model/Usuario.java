package com.back.hostely.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uss_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "uss_nombre", nullable = false)
    private String nombre;

    @Column(name = "uss_foto_perfil")
    private String fotoPerfil;

    @Column(name = "uss_edad")
    private Integer edad;

    @Column(name = "uss_email", nullable = false, unique = true)
    private String email;

    @Column(name = "uss_pais", nullable = false)
    private Integer paisId;

    @Column(name = "uss_direccion")
    private String direccion;

    @Column(name = "uss_telefono")
    private String telefono;

    @Column(name = "uss_estado_social")
    private String estadoSocial;

    @Column(name = "uss_password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "uss_negocio")
    private Integer negocioId;

    @Column(name = "uss_verificado")
    private String verificado;

    @Column(name = "uss_created_at", insertable = false, updatable = false)
    private String creadoEn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_sedes", joinColumns = @JoinColumn(name = "usse_uss"), inverseJoinColumns = @JoinColumn(name = "usse_sede"))
    private Set<Sede> sedes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usrl_uss"), inverseJoinColumns = @JoinColumn(name = "usrl_rol"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioRol> rol;

    public Rol getRolPrincipal() {
        if (rol == null)
            return null;
        return rol.stream()
                .filter(ur -> ur.isPrincipalActivo())
                .map(UsuarioRol::getRol)
                .findFirst()
                .orElse(null);
    }

    // Getters y Setters
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
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
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

    public String getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Set<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(Set<Sede> sedes) {
        this.sedes = sedes;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}