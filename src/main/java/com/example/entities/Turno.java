package com.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCiudadano", nullable = false)
    private Ciudadano ciudadano;

    @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEstado estado;

    public enum TipoEstado{
        PENDIENTE,
        ATENDIDO
    }

    public Turno() {
    }

    public Turno(Long idTurno, LocalDate fecha, TipoEstado estado) {
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }
}
