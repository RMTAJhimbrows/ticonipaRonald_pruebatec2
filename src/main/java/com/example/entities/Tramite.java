package com.example.entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Representa un trámite en el sistema. Un trámite tiene un nombre y está asociado a una lista de turnos.
 */
@Entity
@Table(name = "tramite")
public class Tramite {

    /**
     * Identificador único del trámite, generado automáticamente en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del trámite. No puede ser nulo.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Relación uno a muchos con la entidad Turno.
     * Un trámite puede estar asociado a varios turnos.
     * La relación está mapeada con la propiedad "tramite" de la clase Turno.
     * Se usa FetchType.LAZY para cargar los turnos de forma perezosa (solo cuando se accede a la lista).
     */
    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Turno> turnos;

    public Tramite() {
    }

    public Tramite(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
}
