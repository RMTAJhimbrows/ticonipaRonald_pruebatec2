<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%-- Importar las clases --%>
        <%@ page
            import="java.util.List, com.example.entities.Usuario, com.example.entities.Tramite, com.example.entities.Turno"
            %>
<!DOCTYPE html>
<html>
    <%@ include file="partials/head.jsp" %>
<body>
    <main>
    <%@ include file="partials/header.jsp" %>
    <form action="<%= request.getContextPath() %>/filtrarTurnos" method="post" class="mb-4">
        <div class="row">
            <div class="col-md-3">
                <label for="estado" class="form-label">Filtrar por Estado:</label>
                <select name="estado" id="estado" class="form-select">
                    <option value="">Todos</option>
                    <option value="ESPERA" <%= "ESPERA".equals(request.getAttribute("estado")) ? "selected" : "" %>>En espera</option>
                    <option value="ATENDIDO" <%= "ATENDIDO".equals(request.getAttribute("estado")) ? "selected" : "" %>>Atendidos</option>
                </select>
            </div>
            <div class="col-md-3">
                <label for="fechaInicio" class="form-label">Fecha Inicio:</label>
                <input type="date" name="fechaInicio" id="fechaInicio" class="form-control">
            </div>
            <div class="col-md-3">
                <label for="fechaFin" class="form-label">Fecha Fin:</label>
                <input type="date" name="fechaFin" id="fechaFin" class="form-control">
            </div>
            <div class="col-md-3 d-flex align-items-end">
                <button type="submit" class="btn btn-primary">Filtrar</button>
            </div>
        </div>
    </form>

    <!-- Resultados de los filtros segun las fechas -->
    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Fecha</th>
                <th scope="col">Estado</th>
            </tr>
        </thead>
        <tbody>
            <% List<Turno> turnos = (List<Turno>) request.getAttribute("turnos");
               if (turnos != null && !turnos.isEmpty()) {
                   int index = 1;
                   for (Turno turno : turnos) { %>
                   <tr>
                       <th scope="row"><%= index++ %></th>
                       <td><%= turno.getUsuario().getNombre() %></td>
                       <td><%= turno.getUsuario().getApellido() %></td>
                       <td><%= turno.getFecha() %></td>
                       <td><%= turno.getEstado() %></td>
                   </tr>
               <% } } else { %>
                   <tr>
                       <td colspan="5" class="text-center">No hay turnos disponibles para el filtro aplicado.</td>
                   </tr>
               <% } %>
        </tbody>
    </table>
</main>
    <%@ include file="partials/script.jsp" %>
    <%@ include file="partials/footer.jsp" %>

</body>
</html>