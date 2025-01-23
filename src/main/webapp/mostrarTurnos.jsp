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
                            <div class="container mt-5">
                                <h2 class="mb-4">Lista de Turnos</h2>
                            </div>

                            <table class="table table-bordered">
                                <thead class="table-dark">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellido</th>
                                        <th scope="col">Trámites</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Turno</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <% List<Turno> turnos = (List<Turno>) request.getAttribute("turnos");
                                            if (turnos != null && !turnos.isEmpty()) {
                                            int index = 1;
                                            for (Turno turno : turnos) {
                                            Usuario usuario = turno.getUsuario();
                                            Tramite tramite = turno.getTramite();
                                            %>
                                            <tr>
                                                <th scope="row">
                                                    <%= index++ %>
                                                </th>
                                                <td>
                                                    <%= usuario.getNombre() %>
                                                </td>
                                                <td>
                                                    <%= usuario.getApellido() %>
                                                </td>
                                                <td>
                                                    <%= tramite.getNombre() %>
                                                </td>
                                                <td>
                                                    <%= turno.getFecha() %>
                                                </td>
                                                <td>
                                                    <%= turno.getEstado().name() %>
                                                </td>
                                                <td>
                                                    <%= turno.getCodigo() %>
                                                </td>
                                            </tr>
                                            <% } } else { %>
                                                <tr>
                                                    <td colspan="5" class="text-center">No hay turnos disponibles.</td>
                                                </tr>
                                                <% } %>
                                </tbody>
                            </table>
                    </main>

                    <%@ include file="partials/script.jsp" %>
                        <%@ include file="partials/footer.jsp" %>

                </body>

            </html>