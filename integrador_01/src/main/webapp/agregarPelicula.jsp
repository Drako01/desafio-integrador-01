<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.educacionit.model.Genero"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="Cache-Control">
<meta http-equiv="Pragma" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Agregar Película | Educación IT</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <ul class="d-flex row evenly">
                <li><a href="index.jsp">Inicio</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="d-flex column center bienvenido">
            <h1>Agregar Película</h1>
        </section>
        <section class="d-flex column center bienvenido">
            <form action="PeliculasManagerServlet" method="POST"
                class="d-flex column center">
                <label for="titulo">Título:</label> <input type="text" id="titulo"
                    name="titulo" required> 
                    <label for="imagenPromocional">URL de Imagen:</label> <input type="text" id="imagenPromocional"
                    name="imagenPromocional" required> 
                    <label for="url">URL de Trailer:</label> 
                    <input type="text" id="url"
                    name="url" required> 
                    <label for="generos">Géneros:</label>
                    <select id="generos" name="generos" multiple>
					    <%
					    List<Genero> generos = (List<Genero>) request.getAttribute("generos");
					    if (generos != null && !generos.isEmpty()) {
					        for (Genero genero : generos) {
					    %>
					    <option value="<%=genero.getId()%>"><%=genero.getNombre()%></option>
					    <%
					        }
					    }
					    %>
					</select>
					<br>
                    <input type="submit" value="Agregar Película"
                        class="sin-padding btn">
            </form>
        </section>
    </main>
    <footer class="footer center">
        <p>Educación IT | &copy;</p>
        <p id="hora"></p>
    </footer>
    <script type="text/javascript" src="static/js/reloj.js"></script>
</body>
</html>
