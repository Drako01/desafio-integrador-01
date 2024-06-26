<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.educacionit.model.Pelicula"%>
<%@ page import="com.educacionit.model.Genero"%>
<%@ page import="java.util.List"%>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="Cache-Control">
<meta http-equiv="Pragma" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Detalles de la Película | Educación IT</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
	<header>
		<nav class="navbar">
			<ul class="d-flex row evenly">
				<li><a href="index.jsp">Inicio</a></li>
				<li><a href="BuscarPeliculasServlet">Volver al Buscador</a></li>
				<li><a href="PeliculasManagerServlet">Listar Todas</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<section class="d-flex column center bienvenido">
			<h1>Detalles de la Película</h1>
		</section>
		<section class="d-flex center bienvenido">
			<%
			Pelicula pelicula = (Pelicula) session.getAttribute("peliculaSeleccionada");
			if (pelicula != null) {
			%>
			<div class="detalles-pelicula">
				<img src="<%=pelicula.getImagenPromocional()%>" width="120">
				<h2><%=pelicula.getTitulo()%></h2>
				<p>
					Código:
					<%=pelicula.getCodigo()%></p>
				<p>
					Géneros:
					<%
				List<Genero> generos = pelicula.getGeneros();
				if (generos != null && !generos.isEmpty()) {
					for (int i = 0; i < generos.size(); i++) {
						Genero genero = generos.get(i);
						out.print(genero.getNombre());
						if (i < generos.size() - 1) {
					out.print(", ");
						}
					}
				} else {
					out.print("No especificado");
				}
				%>
				</p>

				<p>
					<a href="<%=pelicula.getUrl()%>" target="_blank">Más
						información</a>
				</p>
			</div>
			<%
			}
			%>
		</section>
	</main>
	<footer class="footer center">
		<p>Educación IT | &copy;</p>
		<p id="hora"></p>
	</footer>
	<script type="text/javascript" src="static/js/reloj.js"></script>
</body>
</html>
