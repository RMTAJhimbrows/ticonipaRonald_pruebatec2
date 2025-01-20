package com.example.servlets;

import com.example.controllers.TramiteController;
import com.example.controllers.TurnoController;
import com.example.entities.Tramite;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listaTramite")
public class TramiteServlet extends HttpServlet {
    private TramiteController tramiteController = new TramiteController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tramite> tramites = tramiteController.finAll();

        req.setAttribute("tramites", tramites);

        req.getRequestDispatcher("crearTurno.jsp").forward(req, resp);

    }
}
