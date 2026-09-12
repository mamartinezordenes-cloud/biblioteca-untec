<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Biblioteca UNTEC</title>
<style>
    body { font-family: Arial, sans-serif; background-color: #f4f6f9; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
    .card { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 300px; }
    h2 { text-align: center; color: #007bff; margin-bottom: 20px; }
    input[type="text"], input[type="password"] { width: 93%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 4px; }
    input[type="submit"] { width: 100%; background: #007bff; color: white; border: none; padding: 10px; border-radius: 4px; cursor: pointer; font-size: 16px; }
    .error { color: red; font-size: 14px; text-align: center; margin-bottom: 10px; }
</style>
</head>
<body>

<div class="card">
    <h2>Biblioteca UNTEC</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="LoginServlet" method="post">
        <label>Usuario:</label>
        <input type="text" name="usuario" required>
        <label>Contraseña:</label>
        <input type="password" name="password" required>
        <input type="submit" value="Ingresar">
    </form>
</div>

</body>
</html>