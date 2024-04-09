<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="Cache-Control">
<meta http-equiv="Pragma" content="no-cache">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bienvenidos | Educación IT</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">

<link rel="stylesheet" type="text/css" href="static/css/style.css">

</head>
<body>
	<header>
		<nav class="navbar">
			<ul class="d-flex row evenly">
				<li><a href="index.jsp">Inicio</a></li>
				<li><a href="BuscarPeliculasServlet">Buscar Pelicula</a></li>				
			</ul>
		</nav>
	</header>
	<main>
		<section class="d-flex column center bienvenido">
			<h1>Desafio Integrador | Educación IT</h1>
			<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Blockbuster_logo.svg/1200px-Blockbuster_logo.svg.png"
			 alt="BlockBuster" class="bienvenido">
		</section>
		<section class=" bienvenido"></section>
	</main>
	<footer class="footer center">
		<p>Educación IT | &copy;</p>
		<p id="hora"></p>
	</footer>
	<script type="text/javascript" src="static/js/reloj.js"></script>
</body>
</html>
