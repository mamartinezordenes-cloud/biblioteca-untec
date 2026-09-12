<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca UNTEC - Libros</title>
<style>
    body { font-family: Arial, sans-serif; margin: 30px; background-color: #f4f6f9; }
    h2, h3 { color: #333; }
    table { width: 100%; border-collapse: collapse; background: #fff; margin-top: 15px; }
    th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
    th { background-color: #007bff; color: white; }
    .form-container { background: #fff; padding: 20px; border-radius: 5px; width: 400px; margin-bottom: 20px; }
    input[type="text"] { width: 90%; padding: 8px; margin: 5px 0 15px 0; }
    button, input[type="submit"] { background: #28a745; color: white; border: none; padding: 8px 15px; cursor: pointer; border-radius: 3px; }
    .btn-prestamo { background: #17a2b8; text-decoration: none; padding: 5px 10px; color: white; border-radius: 3px; display: inline-block; }
    .header { display: flex; justify-content: space-between; align-items: center; }
    .logout { color: #dc3545; text-decoration: none; font-weight: bold; }
</style>
</head>
<body>

    <div class="header">
        <h2>Bienvenido, ${sessionScope.usuarioLogueado.nombre} (${sessionScope.usuarioLogueado.rol})</h2>
        <a href="LoginServlet" class="logout">Cerrar Sesión</a>
    </div>

    <hr>

    <!-- Formulario para agregar libros (Visible para ADMIN) -->
    <c:if test="${sessionScope.usuarioLogueado.rol == 'ADMIN'}">
        <div class="form-container">
            <h3>Agregar Nuevo Libro</h3>
            <form action="LibroServlet" method="post">
                <label>Título:</label><br>
                <input type="text" name="titulo" required><br>
                <label>Autor:</label><br>
                <input type="text" name="autor" required><br>
                <input type="submit" value="Guardar Libro">
            </form>
        </div>
    </c:if>

    <h3>Catálogo de Libros</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="libro" items="${libros}">
                <tr>
                    <td>${libro.id}</td>
                    <td>${libro.titulo}</td>
                    <td>${libro.autor}</td>
                    <td>
                        <c:choose>
                            <c:when test="${libro.disponible}">
                                <span style="color: green; font-weight: bold;">Disponible</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color: red; font-weight: bold;">Prestado</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${libro.disponible}">
                            <form action="PrestamoServlet" method="post" style="display:inline;">
                                <input type="hidden" name="idLibro" value="${libro.id}">
                                <input type="hidden" name="tituloLibro" value="${libro.titulo}">
                                <input type="hidden" name="usuario" value="${sessionScope.usuarioLogueado.nombre}">
                                <button type="submit">Solicitar Préstamo</button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p><a href="PrestamoServlet">Ver Historial de Préstamos</a></p>

</body>
</html>