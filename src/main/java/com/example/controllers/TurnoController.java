package com.example.controllers;

import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.entities.Usuario;
import com.example.persistences.GenericoJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TurnoController {

    private final GenericoJPA<Turno, Integer> turnoJPA;
    private final GenericoJPA<Tramite, Integer> tramiteJPA;
    private final GenericoJPA<Usuario, Integer> usuarioJPA;

    public TurnoController() {
        this.turnoJPA = new GenericoJPA<>(Turno.class);
        this.tramiteJPA = new GenericoJPA<>(Tramite.class);
        this.usuarioJPA = new GenericoJPA<>(Usuario.class);
    }

    public void create(Integer usuarioId, Integer tramiteId, LocalDate fecha) {

        Turno.TipoEstado estado = Turno.TipoEstado.ESPERA;
        String codigo = "1011";// pendiente de generar codigo
        Usuario usuario = usuarioJPA.findOne(usuarioId);
        Tramite tramite = tramiteJPA.findOne(tramiteId);

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

    public List<Turno> findALl() {
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
}
