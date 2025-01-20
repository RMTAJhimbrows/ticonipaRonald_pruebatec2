package com.example.servlets;

import com.example.controllers.TramiteController;
import com.example.controllers.TurnoController;
import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/crearTurnoForm")
public class TurnoServlet extends HttpServlet {

    private TurnoController turnoController = new TurnoController();
    private TramiteController tramiteController = new TramiteController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("crearTurno.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String fechaParam = req.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaParam);
        Integer tramite_id = Integer.valueOf(req.getParameter("tramite_id"));
        Turno.TipoEstado estado = Turno.TipoEstado.ESPERA;
        String codigo = "1011";// pendiente de generar codigo

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);

        Tramite tramiteEncontrado = tramiteController.findOne(tramite_id);

        Turno nuevoTurno = new Turno(null, codigo, fecha, estado, nuevoUsuario, tramiteEncontrado);

        turnoController.create(nuevoTurno);

        resp.sendRedirect(req.getContextPath() + "/usuario");

    }
}
