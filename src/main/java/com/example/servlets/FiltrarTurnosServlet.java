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
        // En este caso, simplemente mostramos el formulario para filtrar turnos.
        req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtiene los parámetros enviados desde el formulario
            String estado = req.getParameter("estado");
            String fechaInicioStr = req.getParameter("fechaInicio");
            String fechaFinStr = req.getParameter("fechaFin");

            // Si algún parámetro es nulo o vacío, redirige al formulario
            if (estado == null || fechaInicioStr == null || fechaFinStr == null || estado.isEmpty() || fechaInicioStr.isEmpty() || fechaFinStr.isEmpty()) {
                req.setAttribute("error", "Todos los filtros deben ser seleccionados.");
                req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
                return;
            }

            // Convierte las fechas a LocalDate
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
            LocalDate fechaFin = LocalDate.parse(fechaFinStr);

            // Obtiene los turnos filtrados
            List<Turno> turnos = turnoController.filtarTurnoFecha(estado, fechaInicio, fechaFin);

            // Pasa los resultados al JSP para mostrar los turnos filtrados
            req.setAttribute("turnos", turnos);

            // Redirige a la página donde se muestran los resultados
            req.getRequestDispatcher("mostrarFiltros.jsp").forward(req, resp);
        } catch (Exception e) {
            // Si hay un error, muestra un mensaje de error
            req.setAttribute("error", "Error al filtrar turnos: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
