<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.educacionit.model.Pelicula"%>
<%@ page import="java.util.List"%>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="Cache-Control">
<meta http-equiv="Pragma" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Lista de Películas | Educación IT</title>
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
			<h1>Lista de Películas</h1>
		</section>
		<section class="d-flex column center bienvenido">
			<table>
				<thead>
					<tr class="cabecera-tabla">
						<th>Código</th>
						<th>Título</th>
						<th>Acceder a Detalles</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
					if (peliculas != null && !peliculas.isEmpty()) {
						for (Pelicula pelicula : peliculas) {
					%>
					<tr class="cuerpo-tabla">
						<td><%=pelicula.getCodigo()%></td>
						<td><%=pelicula.getTitulo()%></td>
						<td>
							<form action="BuscarPeliculasServlet" method="POST"
								class="d-flex center">
								<input type="hidden" name="codigoPelicula"
									value="<%=pelicula.getCodigo()%>"> <input
									type="password" name="codigo_secreto"
									placeholder="Ingrese el código secreto"> <input
									type="submit" value="Detalles" class="sin-padding btn">
							</form>
						</td>
						<td>
							<form action="EliminarPeliculaServlet" method="POST">
								<input type="hidden" name="_method" value="DELETE"> <input
									type="hidden" name="codigo" value="<%=pelicula.getCodigo()%>">
								<input type="submit" value="Eliminar" class="btn red">
							</form>
						</td>



					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="3">No se encontraron películas.</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<br>
			<form action="AgregarPeliculaServlet" method="GET"
				class="d-flex center">
				<input type="submit" value="Agregar Otra" class="sin-padding btn">
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
