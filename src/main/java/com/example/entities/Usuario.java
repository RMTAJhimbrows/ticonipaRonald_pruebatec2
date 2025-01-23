package com.example.entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Representa a un Usuario en el sistema.
 * Cada usuario tiene un identificador único, nombre, apellido y una lista de turnos asociados.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * Identificador único del usuario, generado automáticamente en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del usuario. No puede ser nulo.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Apellido del usuario. No puede ser nulo.
     */
    @Column(nullable = false)
    private String apellido;

    /**
     * Relación de uno a muchos con la entidad Turno.
     * Un usuario puede tener múltiples turnos asociados.
     * La relación es mapeada por el atributo "usuario" en la clase Turno.
     * Utiliza carga perezosa (LAZY) y cascada para operaciones de persistencia.
     */
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Turno> turnos;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
