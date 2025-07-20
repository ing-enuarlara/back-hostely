package com.back.hostely.model;

import com.back.hostely.enums.EstadoFuncion;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "funciones_fichaje")
public class FuncionFichaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funf_id")
    private Integer id;

    @Column(name = "funf_fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "funf_time", nullable = false)
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "funf_estado")
    private EstadoFuncion estado = EstadoFuncion.PENDIENTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funf_funcion", nullable = false)
    private FuncionPuesto funcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funf_fichaje", nullable = false)
    private Fichaje fichaje;

    @Column(name = "funf_created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public EstadoFuncion getEstado() {
        return estado;
    }

    public void setEstado(EstadoFuncion estado) {
        this.estado = estado;
    }

    public FuncionPuesto getFuncion() {
        return funcion;
    }

    public void setFuncion(FuncionPuesto funcion) {
        this.funcion = funcion;
    }

    public Fichaje getFichaje() {
        return fichaje;
    }

    public void setFichaje(Fichaje fichaje) {
        this.fichaje = fichaje;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
