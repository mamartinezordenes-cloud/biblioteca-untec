# Proyecto Biblioteca Digital UNTEC

Aplicación web dinámica desarrollada en Java EE para la gestión de catálogo, préstamos y usuarios de la Biblioteca Digital UNTEC.

## Arquitectura y Tecnologías
* **Patrón de Arquitectura:** MVC (Modelo - Vista - Controlador)
* **Capa de Datos:** DAO (Data Access Object) con patrón Singleton
* **Tecnologías:** Java Servlets, JSP, JSTL, Maven, Base de Datos H2 en memoria
* **Servidor de Aplicaciones:** Apache Tomcat 10+

## Estructura de Paquetes
* `model`: Clases `Libro`, `Usuario`, `Prestamo`
* `dao`: Clases `ConexionBD` (Singleton), `LibroDAO`, `UsuarioDAO`, `PrestamoDAO`
* `controller`: Servlets `LoginServlet`, `LibroServlet`, `PrestamoServlet`
* `webapp`: Vistas JSP (`index.jsp`, `libros.jsp`, `prestamos.jsp`)

## Credenciales de Prueba
* **Administrador:** Usuario: `admin` | Contraseña: `1234`
* **Estudiante:** Usuario: `juan` | Contraseña: `1234`

## Instrucciones de Despliegue
1. Desplegar el archivo `BibliotecaUNTEC.war` en Apache Tomcat.
2. Acceder mediante el navegador a: `http://localhost:8080/BibliotecaUNTEC/`