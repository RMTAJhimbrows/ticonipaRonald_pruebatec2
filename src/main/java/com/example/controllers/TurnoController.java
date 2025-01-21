package com.example.controllers;

import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.entities.Usuario;
import com.example.persistences.GenericoJPA;

import java.time.LocalDate;
import java.util.List;

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
}
