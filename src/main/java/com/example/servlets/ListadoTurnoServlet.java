package com.example.servlets;

import com.example.controllers.TurnoController;
import com.example.entities.Turno;
import com.example.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/mostrarLista")
public class ListadoTurnoServlet extends HttpServlet {
    private TurnoController turnoController = new TurnoController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Turno> turnos = turnoController.findALl();

        req.setAttribute("turnos", turnos);
        req.getRequestDispatcher("mostrarTurnos.jsp").forward(req, resp);
    }
}
