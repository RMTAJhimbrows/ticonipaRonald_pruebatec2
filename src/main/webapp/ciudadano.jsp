<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%-- Importar las clases --%>
        <%@ page
            import="java.util.List, com.example.entities.Ciudadano, com.example.entities.Tramite, com.example.entities.Turno"
            %>


            <!DOCTYPE html>
            <html>
            <%@ include file="partials/head.jsp" %>

                <body>
                    <%@ include file="partials/header.jsp" %>
                        <div class="container mt-5">
                            <h2 class="mb-4">Lista de Ciudadanos</h2>

                        </div>

                        <table class="table table-bordered">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Trámites</th>
                                    <th scope="col">Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% List<Ciudadano> listado = (List<Ciudadano>) request.getAttribute("listado");
                                        if (listado != null && !listado.isEmpty()) {
                                        int index = 1;
                                        for (Ciudadano ciudadano : listado) {
                                        %>
                                        <tr>
                                            <th scope="row">
                                                <%= index++ %>
                                            </th>
                                            <td>
                                                <%= ciudadano.getNombre() %>
                                            </td>
                                            <td>
                                                <%= ciudadano.getApellido() %>
                                            </td>
                                            <td>
                                                <% for (Tramite tramite : ciudadano.getTramites()) {
                                                    out.print(tramite.getNombre() + "<br>" ); } %>
                                            </td>
                                            <td>
                                                <% for (Turno turno : ciudadano.getTurnos()) {
                                                    out.print("ID: " + turno.getIdTurno() + " -Estado: " + turno.getEstado() + " <br>");
                                                    }
                                                    %>
                                            </td>
                                        </tr>
                                        <% } } else { %>
                                            <tr>
                                                <td colspan="5" class="text-center">No hay ciudadanos disponibles.</td>
                                            </tr>
                                            <% } %>
                            </tbody>
                        </table>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                            crossorigin="anonymous"></script>
                </body>

            </html>