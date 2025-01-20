<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List, com.example.entities.Usuario, com.example.entities.Turno, com.example.entities.Tramite" %>
  <!DOCTYPE html>
  <html>
  <%@ include file="partials/head.jsp" %>

    <body>
      <%@ include file="partials/header.jsp" %>

        <div class="container mt-5">
          <h2 class="mb-4">Formulario de Registro</h2>
          <form action="/app/crearTurnoForm" method="post">

            <!-- Nombre -->
            <div class="mb-3">
              <label for="nombre" class="form-label">Nombre</label>
              <input type="text" name="nombre" class="form-control" id="nombre" placeholder="Ingresa tu nombre"
                required>
            </div>

            <!-- Apellido -->
            <div class="mb-3">
              <label for="apellido" class="form-label">Apellido</label>
              <input type="text" name="apellido" class="form-control" id="apellido" placeholder="Ingresa tu Apellido"
                required>
            </div>

            <!-- Tipo de Tramite -->
            <select name="tipoTramite" id="tipoTramite" onchange="mostrarTramiteSeleccionado()" required>
              <option value="" selected disabled>Seleccione un trámite</option>

              <% List<Tramite> tramites = (List<Tramite>)request.getAttribute("tramites"); 

                for(Tramite tramite: tramites){%>
                  
              <option value="<%= tramite.getId() %>"><%= tramite.getNombre()%></option>

              <% } %>
            </select>
            <p>Tramite seleccionada: <span id="tramiteSeleccionado">Ninguna</span></p>


            <!-- Seleccionar fecha -->
            <div class="container mt-5">
              <h2>Seleccionar una Fecha</h2>
              <!-- Campo de fecha -->
              <div class="form-group">
                <label for="datepicker" class="form-label">Fecha:</label>
                <input type="text" class="form-control" id="datepicker" placeholder="Selecciona una fecha">
              </div>
              
              <!-- Mostrar la fecha seleccionada -->
              <div class="mt-3">
                <p>Fecha seleccionada: <span id="selected-date">Ninguna</span></p>
              </div>
            </div>

            <!-- Checkbox -->
            <div class="form-check mb-3">
              <input class="form-check-input" type="checkbox" id="terminos" required>
              <label class="form-check-label" for="terminos">
                Acepto los términos y condiciones
              </label>
            </div>

            <!-- Botón de envío -->
            <button type="submit" class="btn btn-primary">Solicitar Turno</button>
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