package com.example.servlets;

import com.example.controllers.UsuarioController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/crearUsuario")
public class CrearUsuarioServlet extends HttpServlet {
    UsuarioController usuarioController = new UsuarioController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("crearUsuario.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");

        usuarioController.create(nombre, apellido);

        resp.sendRedirect(req.getContextPath() + "/mostrarLista");

    }

}
