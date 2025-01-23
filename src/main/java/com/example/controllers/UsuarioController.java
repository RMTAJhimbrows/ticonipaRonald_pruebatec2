package com.example.controllers;

import com.example.entities.Usuario;
import com.example.persistences.GenericoJPA;

import java.util.List;


/**
 * Controlador para gestionar las operaciones relacionadas con la entidad Usuario.
 * Este controlador interactúa con la base de datos mediante un objeto GenericoJPA.
 */
public class UsuarioController {
    private final GenericoJPA<Usuario, Integer> usuarioJPA;

    public UsuarioController() {
        this.usuarioJPA = new GenericoJPA<>(Usuario.class);
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param usuarioId ID del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    public Usuario findOne(Integer usuarioId) {
        return usuarioJPA.findOne(usuarioId);
    }

    /**
     * Obtiene todos los usuarios almacenados en la base de datos.
     *
     * @return Lista de todos los usuarios.
     */

    public List<Usuario> findAll() {
        return usuarioJPA.findAll();
    }

    /**
     * Crea un nuevo usuario con el nombre y apellido proporcionados.
     *
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     */
    public void create(String nombre, String apellido) {
        // Crea una nueva instancia de Usuario.
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);

        // Guarda el usuario en la base de datos.
        usuarioJPA.create(usuario);
    }
}
