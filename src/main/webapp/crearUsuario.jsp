<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>
    <%@ include file="partials/head.jsp" %>

        <body>
            <main>
                <%@ include file="partials/header.jsp" %>
                    <div class="d-flex justify-content-center align-items-center vh-100">
                        <form action="crearUsuario" method="post" class="p-4 shadow-lg rounded bg-light">
                            <h3 class="mb-4 text-center text-dark">Regístrate</h3>

                            <!-- Nombre -->
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" name="nombre" class="form-control" id="nombre"
                                    placeholder="Ingrese su nombre..." required>
                            </div>

                            <!-- Apellido -->
                            <div class="mb-3">
                                <label for="apellido" class="form-label">Apellido</label>
                                <input type="text" name="apellido" class="form-control" id="apellido"
                                    placeholder="Ingrese su apellido..." required>
                            </div>

                            <!-- Botón de enviar -->
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary btn-lg">Crear Usuario</button>
                            </div>
                        </form>
                    </div>
            </main>
            <%@ include file="partials/script.jsp" %>
                <%@ include file="partials/footer.jsp" %>


        </body>

    </html>