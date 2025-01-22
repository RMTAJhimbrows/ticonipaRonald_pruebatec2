package com.example.servlets;

import com.example.controllers.TurnoController;
import com.example.entities.Turno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/filtrarTurnos")
public class FiltrarTurnosServlet extends HttpServlet {
    private TurnoController turnoController = new TurnoController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String estado = req.getParameter("estado");
            LocalDate fechaInicio = LocalDate.parse(req.getParameter("fechaInicio"));
            LocalDate fechaFin = LocalDate.parse(req.getParameter("fechaFin"));

            List<Turno> turnos = turnoController.filtarTurnoFecha(estado, fechaInicio, fechaFin);

            req.setAttribute("turnos", turnos);
            req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
        } catch (Exception e){
            req.setAttribute("error", "Error al filtrar turnos: " + e.getMessage());
            req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        try {
            String estado = req.getParameter("estado");
            LocalDate fechaInicio = LocalDate.parse(req.getParameter("fechaInicio"));
            LocalDate fechaFin = LocalDate.parse(req.getParameter("fechaFin"));

            List<Turno> turnos = turnoController.filtarTurnoFecha(estado, fechaInicio, fechaFin);

            req.setAttribute("turnos", turnos);
            req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
        } catch (Exception e){
            req.setAttribute("error", "Error al filtrar turnos: " + e.getMessage());
            req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
        }

         */
    }
}
