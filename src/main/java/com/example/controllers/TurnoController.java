package com.example.controllers;

import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.persistences.GenericoJPA;

public class TurnoController {

    private final GenericoJPA<Turno, Integer> turnoJPA;

    public TurnoController() {
        this.turnoJPA = new GenericoJPA<>(Turno.class);
    }

    public void create(Turno nuevoTurno) {
        turnoJPA.create(nuevoTurno);
    }
}
