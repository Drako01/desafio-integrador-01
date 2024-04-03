package com.educacionit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.conexion.DAOManager;
import com.educacionit.excepciones.DBManagerException;
import com.educacionit.model.Pelicula;

public class ListarPeliculasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Instanciamos el DAOManager
		DAOManager daoManager = new DAOManager();
		try {
			daoManager.verificarYCrearTabla();
		} catch (DBManagerException e) {
			e.printStackTrace();
		}
		
		try {
			// Obtener la lista de películas del DAOManager
			List<Pelicula> peliculas = daoManager.mostrarLasPeliculas();

			// Guardar la lista de películas en el alcance de la solicitud
			request.setAttribute("peliculas", peliculas);

			// Redirigir la solicitud al archivo JSP correspondiente
			request.getRequestDispatcher("/listadoPeliculas.jsp").forward(request, response);

		} catch (DBManagerException e) {
			// Manejar la excepción adecuadamente (redirigir a una página de error, etc.)
			e.printStackTrace();
			response.getWriter().println("Error al obtener las películas: " + e.getMessage());
		}
	}

}
