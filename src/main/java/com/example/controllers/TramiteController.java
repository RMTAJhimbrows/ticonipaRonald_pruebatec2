package com.example.controllers;

import com.example.entities.Tramite;
import com.example.persistences.GenericoJPA;

import java.util.List;

public class TramiteController {
    private final GenericoJPA<Tramite, Integer> tramiteJPA;

    public TramiteController() {
        this.tramiteJPA = new GenericoJPA<>(Tramite.class);
    }

    public Tramite findOne(Integer tramite_id) {
        return tramiteJPA.findOne(tramite_id);
    }


    public List<Tramite> finAll() {
        List<Tramite> tramites = tramiteJPA.findAll();
        if (tramites == null || tramites.isEmpty()) {
            System.out.println("No se encontraron trámites en la base de datos.");
        } else {
            System.out.println("Trámites cargados: " + tramites.size());
            tramites.forEach(t -> System.out.println("Trámite: " + t.getId() + ", Nombre: " + t.getNombre()));

        }
        return tramites;
    }
}
