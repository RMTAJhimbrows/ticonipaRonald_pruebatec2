package com.example.controllers;

import com.example.entities.Tramite;
import com.example.persistences.GenericoJPA;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con la entidad Tramite.
 * Este controlador utiliza un objeto GenericoJPA para interactuar con la base de datos.
 */
public class TramiteController {
    private final GenericoJPA<Tramite, Integer> tramiteJPA;

    public TramiteController() {
        this.tramiteJPA = new GenericoJPA<>(Tramite.class);
    }

    /**
     * Busca un trámite por su ID.
     *
     * @param tramite_id El ID del trámite a buscar.
     * @return El trámite encontrado o null si no existe.
     */
    public Tramite findOne(Integer tramite_id) {

        return tramiteJPA.findOne(tramite_id);
    }

    /**
     * Obtiene una lista de todos los trámites almacenados en la base de datos.
     *
     * @return Una lista con todos los trámites.
     */
    public List<Tramite> findAll() {
        return tramiteJPA.findAll();
    }
}
