package com.example.servlets;

import com.example.controllers.TramiteController;
import com.example.controllers.TurnoController;
import com.example.controllers.UsuarioController;
import com.example.entities.Tramite;
import com.example.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/crearTurnoForm")
public class CrearTurnoServlet extends HttpServlet {

    private UsuarioController usuarioController = new UsuarioController();
    private TurnoController turnoController = new TurnoController();
    private TramiteController tramiteController = new TramiteController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioController.findAll();
        req.setAttribute("usuarios", usuarios);
        List<Tramite> tramites = tramiteController.findAll();
        req.setAttribute("tramites", tramites);

        req.getRequestDispatcher("crearTurno.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
            Integer tramiteId = Integer.parseInt(req.getParameter("tramiteId"));
            LocalDate fecha = LocalDate.parse(req.getParameter("fecha"));

            turnoController.create(usuarioId, tramiteId, fecha);

            resp.sendRedirect(req.getContextPath() + "/mostrarLista");

        } catch (Exception e){
            req.setAttribute("error", "Error al crear turno: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
