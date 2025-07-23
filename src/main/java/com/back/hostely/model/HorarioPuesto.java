package com.back.hostely.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "horario_puesto")
public class HorarioPuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horp_id")
    private Integer id;

    @Column(name = "horp_time_inicio", nullable = false)
    private LocalTime timeInicio;

    @Column(name = "horp_time_fin", nullable = false)
    private LocalTime timeFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horp_puesto", nullable = false)
    private Puesto puesto;

    @Column(name = "horp_created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getTimeInicio() {
        return timeInicio;
    }

    public void setTimeInicio(LocalTime timeInicio) {
        this.timeInicio = timeInicio;
    }

    public LocalTime getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(LocalTime timeFin) {
        this.timeFin = timeFin;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}