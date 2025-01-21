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

                        <button type="submit">Filtrar por Nombre</button>
                        <button type="submit">Filtrar por Tramite</button>
                        <button type="submit">Filtrar por Fecha</button>



                    </form>