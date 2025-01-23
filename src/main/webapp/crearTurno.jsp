<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ page
        import="java.util.List, com.example.entities.Usuario, com.example.entities.Turno, com.example.entities.Tramite"
        %>
        <!DOCTYPE html>
        <html>
        <%@ include file="partials/head.jsp" %>

            <body>
                <main>
                    <%@ include file="partials/header.jsp" %>

                        <div class="d-flex justify-content-center align-items-center vh-100">
                            <form action="crearTurnoForm" method="post" class="p-4 shadow-lg rounded bg-light">

                                <h2 class="mb-4">Solicitar Turno</h2>
                                <div class="mb-3">
                                    <label for="usuarioId" class="form-label">Usuario</label>
                                    <select class="form-select" id="usuarioId" name="usuarioId" required>
                                       <option value="" disabled selected>Selecciona Usuario...</option>
                                        <%-- Llenar con usuarios disponibles --%>
                                            <% List<Usuario> usuarios = (List<Usuario>)
                                                    request.getAttribute("usuarios");
                                                    for (Usuario usuario : usuarios) { %>
                                                    <option value="<%= usuario.getId() %>">
                                                        <%= usuario.getNombre() %>
                                                            <%= usuario.getApellido() %>
                                                    </option>
                                                    <% } %>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label for="tramiteId" class="form-label">Trámite</label>
                                    <select class="form-select" id="tramiteId" name="tramiteId" required>
                                        <option value="" disabled selected>Seleciona Tipo Tramite...</option>
                                        <%-- Llenar con trámites disponibles --%>
                                            <% List<Tramite> tramites = (List<Tramite>)
                                                    request.getAttribute("tramites");
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



                                <button type="submit" class="btn btn-primary">Crear Turno</button>
                            </form>
                        </div>
                </main>
                <%@ include file="partials/script.jsp" %>
                    <script src="public/js/script.js"></script>
                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>