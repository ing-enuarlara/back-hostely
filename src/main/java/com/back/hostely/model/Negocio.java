package com.back.hostely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "negocios")
public class Negocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nego_id")
    private Integer id;

    @Column(name = "nego_email", nullable = false, unique = true)
    private String email;

    @Column(name = "nego_tipo", nullable = false)
    private Integer tipo;

    @Column(name = "nego_razon_social")
    private String razonSocial;

    @Column(name = "nego_num_empleados")
    private String numEmpleados;

    @Column(name = "nego_pais", nullable = false)
    private Integer pais;

    @Column(name = "nego_telefono")
    private Integer telefono;

    @Column(name = "nego_direccion")
    private String direccion;

    @Column(name = "nego_uss_admin")
    private Integer ussAdmin;

    @Column(name = "nego_creado_en")
    private String creadoEn;

    // Getters y Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getTipo() { return tipo; }
    public void setTipo(Integer tipo) { this.tipo = tipo; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getNumEmpleados() { return numEmpleados; }
    public void setNumEmpleados(String numEmpleados) { this.numEmpleados = numEmpleados; }

    public Integer getPais() { return pais; }
    public void setPais(Integer pais) { this.pais = pais; }

    public Integer getTelefono() { return telefono; }
    public void setTelefono(Integer telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getUssAdmin() { return ussAdmin; }
    public void setUssAdmin(Integer ussAdmin) { this.ussAdmin = ussAdmin; }

    public String getCreadoEn() { return creadoEn; }
    public void setCreadoEn(String creadoEn) { this.creadoEn = creadoEn; }
}