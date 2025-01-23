package com.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Representa un turno en el sistema. Un turno está asociado a un usuario y un trámite.
 * Además, tiene un código único, una fecha y un estado que indica si está en espera o atendido.
 */
@Entity
@Table(name = "turno")
public class Turno {

    /**
     * Identificador único del turno, generado automáticamente en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Código único del turno. No puede ser nulo.
     */
    @Column(nullable = false)
    private Integer codigo;

    /**
     * Fecha en la que se asigna el turno. No puede ser nula.
     */
    @Column(nullable = false)
    private LocalDate fecha;

    /**
     * Estado del turno. Puede ser "ESPERA" o "ATENDIDO".
     * El estado es de tipo enumerado, se mapea como una cadena.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEstado estado;

    /**
     * Relación muchos a uno con la entidad Usuario.
     * Un turno está asignado a un usuario específico. No puede ser nulo.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Relación muchos a uno con la entidad Tramite.
     * Un turno está asociado a un trámite específico. No puede ser nulo.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;

    /**
     * Enum que representa los posibles estados de un turno.
     * "ESPERA" indica que el turno está en espera y "ATENDIDO" indica que el turno ha sido atendido.
     */
    public enum TipoEstado{
        ESPERA,
        ATENDIDO
    }

    public Turno() {
    }

    public Turno(Integer id, Integer codigo, LocalDate fecha, TipoEstado estado, Usuario usuario, Tramite tramite) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.tramite = tramite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
}
