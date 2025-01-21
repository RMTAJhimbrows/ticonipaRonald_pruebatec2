<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List, com.example.entities.Usuario, com.example.entities.Turno, com.example.entities.Tramite" %>
  <!DOCTYPE html>
  <html>
  <%@ include file="partials/head.jsp" %>

    <body>
      <%@ include file="partials/header.jsp" %>

        <div class="container mt-5">
          <h2 class="mb-4">Formulario de Registro</h2>
          <form action="crearTurnoForm" method="post">
            <div class="mb-3">
                <label for="usuarioId" class="form-label">Usuario</label>
                <select class="form-select" id="usuarioId" name="usuarioId" required>
                    <%-- Llenar con usuarios disponibles --%>
                    <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                       for (Usuario usuario : usuarios) { %>
                        <option value="<%= usuario.getId() %>">
                            <%= usuario.getNombre() %> <%= usuario.getApellido() %>
                        </option>
                    <% } %>
                </select>
            </div>
        
            <div class="mb-3">
                <label for="tramiteId" class="form-label">Trámite</label>
                <select class="form-select" id="tramiteId" name="tramiteId" required>
                    <%-- Llenar con trámites disponibles --%>
                    <% List<Tramite> tramites = (List<Tramite>) request.getAttribute("tramites");
                       for (Tramite tramite : tramites) { %>
                        <option value="<%= tramite.getId() %>">
                            <%= tramite.getNombre() %>
                        </option>
                    <% } %>
                </select>
            </div>
        
            <div class="mb-3">
                <label for="fecha" class="form-label">Fecha</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required>
            </div>
        
            <div class="mb-3">
                <label for="estado" class="form-label">Estado</label>
                <select class="form-select" id="estado" name="estado" required>
                    <option value="ESPERA">En espera</option>
                    <option value="ATENDIDO">Atendido</option>
                </select>
            </div>
        
            <button type="submit" class="btn btn-primary">Crear Turno</button>
        </form>
        </div>
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- jQuery (Requerido por Datepicker) -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <!-- Bootstrap Datepicker JS -->
        <script
          src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

          <script src="public/js/script.js"></script>
    </body>

  </html>