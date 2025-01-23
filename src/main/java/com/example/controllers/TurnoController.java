package com.example.controllers;

import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.entities.Usuario;
import com.example.persistences.GenericoJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Controlador para gestionar las operaciones relacionadas con la entidad Turno.
 * Este controlador interactúa con la base de datos mediante un objeto GenericoJPA.
 */
public class TurnoController {

    // Objetos de persistencia genéricos para las entidades Turno, Tramite y Usuario.
    private final GenericoJPA<Turno, Integer> turnoJPA;
    private final GenericoJPA<Tramite, Integer> tramiteJPA;
    private final GenericoJPA<Usuario, Integer> usuarioJPA;

    /**
     * Constructor que inicializa los objetos GenericoJPA para las entidades correspondientes.
     */
    public TurnoController() {
        this.turnoJPA = new GenericoJPA<>(Turno.class);
        this.tramiteJPA = new GenericoJPA<>(Tramite.class);
        this.usuarioJPA = new GenericoJPA<>(Usuario.class);
    }

    /**
     * Crea un nuevo turno en la base de datos.
     *
     * @param usuarioId ID del usuario asociado al turno.
     * @param tramiteId ID del trámite asociado al turno.
     * @param fecha Fecha del turno.
     * @throws IllegalArgumentException Si el usuario o el trámite no existen en la base de datos.
     */
    public void create(Integer usuarioId, Integer tramiteId, LocalDate fecha) {

        // Genera el número de turno único.
        Integer codigo = obtenerNumero();

        // Estado inicial del turno.
        Turno.TipoEstado estado = Turno.TipoEstado.ESPERA;

        // Busca el usuario y el trámite en la base de datos.
        Usuario usuario = usuarioJPA.findOne(usuarioId);
        Tramite tramite = tramiteJPA.findOne(tramiteId);

        // Verifica que usuario y trámite existan.
        if (usuario == null || tramite == null) {
            throw new IllegalArgumentException("Usuario o trámite no encontrado");
        }

        Turno turno = new Turno();
        turno.setCodigo(codigo);
        turno.setFecha(fecha);
        turno.setEstado(estado);
        turno.setUsuario(usuario);
        turno.setTramite(tramite);

        turnoJPA.create(turno);
    }

    /**
     * Obtiene todos los turnos almacenados en la base de datos.
     *
     * @return Lista de todos los turnos.
     */
    public List<Turno> findAll() {
        return turnoJPA.findAll();
    }

    /**
     * Filtrar turnos por estado utilizando stream.
     * @param estado El estado por el cual se va a filtrar (puede ser null o vacío para devolver todos).
     * @param fechaInicio La fecha de inicio del rango(puede ser null para ignorar).
     * @param fechaFin La fecha de fin del rango (puede ser null para ignorar) .
     * @return Lista de turnos filtrados.
     */
    public List<Turno> filtarTurnoFecha(String estado, LocalDate fechaInicio, LocalDate fechaFin) {

        List<Turno> turnos = turnoJPA.findAll();

        return turnos.stream()
                .filter(turno -> (estado == null || estado.isEmpty() || turno.getEstado().toString().equalsIgnoreCase(estado)))
                .filter(turno -> (fechaInicio == null || !turno.getFecha().isBefore(fechaInicio)))
                .filter(turno -> (fechaFin == null || !turno.getFecha().isAfter(fechaFin)))
                .collect(Collectors.toList());
    }

    /**
     * Genera el número de turno único sumando 1 al mayor número de turno existente.
     *
     * @return El siguiente número de turno disponible.
     */
    public Integer obtenerNumero(){
        List<Turno> turnos = turnoJPA.findAll();

        // Encuentra el código más alto y le suma 1; si no hay turnos, devuelve 1.
        return turnos.stream()
                .mapToInt(Turno::getCodigo)
                .max()
                .orElse(0) + 1;
    }
}

