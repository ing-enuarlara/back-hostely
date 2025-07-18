package com.back.hostely.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_seguimiento")
public class TaskSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tase_id")
    private Integer id;

    @Column(name = "tase_descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tase_adjunto")
    private String adjunto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tase_task", nullable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tase_created_by", nullable = false)
    private Usuario creadoPor;

    @Column(name = "tase_created_at", nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    // Getters y setters completos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}