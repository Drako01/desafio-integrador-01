package com.educacionit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.dao.DAOGenerosImplements;
import com.educacionit.dao.DAOPeliculasImplements;
import com.educacionit.excepciones.DBManagerException;
import com.educacionit.model.Genero;
import com.educacionit.model.Pelicula;

public class BuscarPeliculasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros de búsqueda de la solicitud HTTP
        String genero = request.getParameter("genero");
        String titulo = request.getParameter("titulo");

        // Instanciamos el DAO
        DAOPeliculasImplements daoPeliculasManager = new DAOPeliculasImplements();
        DAOGenerosImplements daoGenerosManager = new DAOGenerosImplements();
        try {
            // Inicializar lista de películas encontradas
            List<Pelicula> peliculas = null; // Inicializo la lista como nula

            if (genero != null && !genero.isEmpty()) {
                // Busco películas por género
                peliculas = daoPeliculasManager.buscarPeliculasPorGenero(genero);
            } else if (titulo != null && !titulo.isEmpty()) {
                // Busco películas por título
                peliculas = daoPeliculasManager.buscarPeliculasPorTitulo(titulo);
            }

            // Guardo la lista de películas en el alcance de la solicitud
            // solo si se realizó una búsqueda
            if (peliculas != null && !peliculas.isEmpty()) {
                request.setAttribute("peliculas", peliculas);
            }

            // Obtener la lista de géneros para mostrar en el formulario de búsqueda
            List<Genero> generos = daoGenerosManager.mostrarLosGeneros();
            request.setAttribute("generos", generos);

            // Redirigir la solicitud al archivo JSP correspondiente
            request.getRequestDispatcher("/buscarPeliculas.jsp").forward(request, response);

        } catch (DBManagerException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error al obtener las películas: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String codigo_secreto = "Educacionit"; // Código secreto hardcodeado
        session.setAttribute("codigo_secreto", codigo_secreto);

        String claveIngresada = request.getParameter("codigo_secreto");

        if (claveIngresada != null && claveIngresada.equals(codigo_secreto)) {
            // Obtener el código de la película seleccionada
            String codigoPeliculaString = request.getParameter("codigoPelicula");
            if (codigoPeliculaString != null && !codigoPeliculaString.isEmpty()) {
                int codigoPelicula = Integer.parseInt(codigoPeliculaString);
                DAOPeliculasImplements daoPeliculasManager = new DAOPeliculasImplements();
                try {
                    // Obtener la película por su ID
                    Pelicula pelicula = daoPeliculasManager.obtenerPeliculaPorID(codigoPelicula);
                    // Guardar la película en el alcance de sesión para usarla en la página de
                    // detalles
                    session.setAttribute("peliculaSeleccionada", pelicula);

                    // Redirigir a la página de detalles
                    response.sendRedirect("paginaDetalles.jsp");
                    return;
                } catch (DBManagerException e) {
                    e.printStackTrace();
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.getWriter().println("Error al obtener la película: " + e.getMessage());
                    return;
                }
            } else {
                response.sendRedirect("errorClave.jsp");
                return;
            }
        } else {
            response.sendRedirect("errorClave.jsp");
            return;
        }
    }

}
