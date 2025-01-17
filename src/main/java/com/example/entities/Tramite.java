package com.example.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tramite")
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramite;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "ciudadanos", fetch = FetchType.LAZY)
    private Set<Ciudadano> ciudadanos = new HashSet<>();

    public Tramite() {
    }

    public Tramite(Long idTramite, String nombre) {
        this.idTramite = idTramite;
        this.nombre = nombre;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(Set<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }
}
