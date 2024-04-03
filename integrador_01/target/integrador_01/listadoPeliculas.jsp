<%@ page import="com.educacionit.model.Pelicula"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="Cache-Control">
<meta http-equiv="Pragma" content="no-cache">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bienvenidos | Educación IT</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css">

</head>
<body>
    <header> </header>
    <main>
        <h1>Listado de Peliculas</h1>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Título</th>
                    <th>URL</th>
                    <th>Imagen Promocional</th>
                    <th>Géneros</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
                    if (peliculas != null) {
                        for (int i = 0; i < peliculas.size(); i++) {
                            Pelicula pelicula = peliculas.get(i);
                %>
                <tr>
                    <td><%= pelicula.getCodigo() %></td>
                    <td><%= pelicula.getTitulo() %></td>
                    <td>
                        <video width="120" height="80" controls>
                            <source src="<%= pelicula.getUrl() %>" type="video/mp4">
                            Your browser does not support the video tag.
                        </video>
                    </td>
                    <td>
                        <img src="<%= pelicula.getImagen_promocional() %>"
                        width="120" height="80">
                    </td>
                    <td><%= pelicula.getGeneros() %></td>
                </tr>
                <% 
                        }
                    } else {
                        out.println("<tr><td colspan='5'>No hay películas disponibles</td></tr>");
                    }
                %>
            </tbody>
        </table>
    </main>
    <footer class="footer center">
        <p>Educación IT | &copy;</p>
        <p id="hora"></p>
    </footer>
    <script type="text/javascript" src="static/js/reloj.js"></script>
</body>
</html>
