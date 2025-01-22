package com.example.controllers;

import com.example.entities.Usuario;
import com.example.persistences.GenericoJPA;

import java.util.List;

public class UsuarioController {
    private final GenericoJPA<Usuario, Integer> usuarioJPA;

    public UsuarioController() {
        this.usuarioJPA = new GenericoJPA<>(Usuario.class);
    }

    public Usuario findOne(Integer usuarioId) {
        return usuarioJPA.findOne(usuarioId);
    }

    public List<Usuario> findAll() {
        return usuarioJPA.findAll();
    }

    public void create(String nombre, String apellido) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuarioJPA.create(usuario);
    }
}
