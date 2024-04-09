package com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.dao.DAOPeliculasImplements;
import com.educacionit.excepciones.DBManagerException;

public class EliminarPeliculaServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtengo el código de la película a eliminar desde la solicitud
        String codigoPelicula = request.getParameter("codigo");

        try {
            // Creo una instancia del DAO para administrar películas
            DAOPeliculasImplements daoPeliculasManager = new DAOPeliculasImplements();

            // Convierto el código de película a entero
            int codigo = Integer.parseInt(codigoPelicula);

            // Llamo al método para eliminar la película
            daoPeliculasManager.eliminarPelicula(codigo);

            // Después de eliminar la película,redirijo a listar peliculas nuevamente
            response.sendRedirect("PeliculasManagerServlet");
        } catch (NumberFormatException e) {
            // En caso de que el parámetro "codigo" no sea un número válido
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("El código de la película no es válido.");
        } catch (DBManagerException e) {
            // Manejo el caso en el que ocurra un error al eliminar la película
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error al eliminar la película: " + e.getMessage());
        }
    }
}
