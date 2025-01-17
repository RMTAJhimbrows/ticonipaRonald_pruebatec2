package com.example.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
 @Table(name = "ciudadano")
public class Ciudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudadano;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ciudadano_tramite",
            joinColumns = @JoinColumn(name = "idCiudadano"),
            inverseJoinColumns = @JoinColumn(name = "idTramite"))
    private Set<Tramite> tramites = new HashSet<>();

    @OneToMany(mappedBy = "ciudadano",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private Set<Turno> turnos;

    public Ciudadano() {
    }

    public Ciudadano(Long idCiudadano, String nombre, String apellido) {
        this.idCiudadano = idCiudadano;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Long idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(Set<Tramite> tramites) {
        this.tramites = tramites;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "idCiudadano=" + idCiudadano +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tramites=" + tramites +
                ", turnos=" + turnos +
                '}';
    }
}
