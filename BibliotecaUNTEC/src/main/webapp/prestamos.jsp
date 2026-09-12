<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca UNTEC - Historial de Préstamos</title>
<style>
    body { font-family: Arial, sans-serif; margin: 30px; background-color: #f4f6f9; }
    h2 { color: #333; }
    table { width: 100%; border-collapse: collapse; background: #fff; margin-top: 15px; }
    th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
    th { background-color: #17a2b8; color: white; }
    .btn-volver { display: inline-block; margin-top: 20px; text-decoration: none; color: #007bff; font-weight: bold; }
</style>
</head>
<body>

    <h2>Historial General de Préstamos</h2>

    <table>
        <thead>
            <tr>
                <th>ID Préstamo</th>
                <th>ID Libro</th>
                <th>Título del Libro</th>
                <th>Usuario</th>
                <th>Fecha de Solicitud</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${prestamos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.idLibro}</td>
                    <td>${p.tituloLibro}</td>
                    <td>${p.usuario}</td>
                    <td>${p.fechaPrestamo}</td>
                    <td><b style="color: blue;">${p.estado}</b></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="LibroServlet" class="btn-volver">← Volver al Catálogo de Libros</a>

</body>
</html>