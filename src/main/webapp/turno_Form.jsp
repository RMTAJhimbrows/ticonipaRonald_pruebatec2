<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page
        import="java.util.List, com.example.entities.Ciudadano, com.example.entities.Tramite, com.example.entities.Turno"
        %>
        <!DOCTYPE html>
        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <%@ include file="partials/header.jsp" %>

                    <br><br>
                    <form action="/app/turnoForm" method="post">

                        <label for="opciones">Selecciona una opción:</label> <br>
                        <select id="opciones" name="idCiudadano" required>
                            <option value="" disabled selected>-- Selecciona una opción --</option>
                            <% List<Ciudadano> listado = (List<Ciudadano>) request.getAttribute("listado");

                                    for(Ciudadano ciudadano: listado) { %>
                                    <option value="<%= ciudadano.getIdCiudadano() %>">
                                        <%= ciudadano.getNombre() %>
                                            <%= ciudadano.getApellido() %>
                                    </option>
                                    <% } %>
                        </select>

                        <br><br>

                        <select id="opciones" name="tipo" required>
                            <option value="ATENDIDO" selected>-- ATENDIDO --</option>
                            <option value="ESPERA">-- ESPERA --</option>
                        </select>

                        <br><br>

                        <button type="submit">Guardar ciudadano</button>

                    </form>