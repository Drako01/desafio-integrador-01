package com.educacionit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.dao.DAOGenerosImplements;
import com.educacionit.dao.DAOPeliculasImplements;
import com.educacionit.excepciones.DBManagerException;
import com.educacionit.model.Genero;
import com.educacionit.model.Pelicula;

public class PeliculasManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        DAOPeliculasImplements daoPeliculasManager = new DAOPeliculasImplements();
	        DAOGenerosImplements daoGenerosManager = new DAOGenerosImplements();
	        List<Pelicula> peliculas = daoPeliculasManager.mostrarLasPeliculas();

            if (peliculas != null && !peliculas.isEmpty()) {
                request.setAttribute("peliculas", peliculas);
            }

            List<Genero> generos = daoGenerosManager.mostrarLosGeneros();
            request.setAttribute("generos", generos);
	        request.getRequestDispatcher("/listarPeliculas.jsp").forward(request, response);
	    } catch (DBManagerException e) {
	        e.printStackTrace();
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.getWriter().println("Error al obtener las películas: " + e.getMessage());
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String titulo = request.getParameter("titulo");
	    String url = request.getParameter("url");
	    String imagenPromocional = request.getParameter("imagenPromocional");
	    String[] generosSeleccionados = request.getParameterValues("generos");

	    // Crear una nueva película con los datos recibidos
	    Pelicula pelicula = new Pelicula();
	    pelicula.setTitulo(titulo);
	    pelicula.setUrl(url);
	    pelicula.setImagenPromocional(imagenPromocional);
	    
	    // Obtener la lista de géneros seleccionados y agregarlos a la película
	    List<Genero> generos = new ArrayList<>();
	    if (generosSeleccionados != null) {
	        for (String idGenero : generosSeleccionados) {
	            Genero genero = new Genero();
	            genero.setId(Integer.parseInt(idGenero));
	            generos.add(genero);
	        }
	    }
	    pelicula.setGeneros(generos);
	    // Llamar al método para insertar la película en la base de datos
	    try {
	        DAOPeliculasImplements daoPeliculasManager = new DAOPeliculasImplements();
	        daoPeliculasManager.insertarPelicula(pelicula);
	        
	        // Redireccionar al usuario a la página de éxito después de agregar la película
	        response.sendRedirect("agregarPelicula.jsp");
	    } catch (DBManagerException e) {
	        e.printStackTrace();
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.getWriter().println("Error al agregar la película: " + e.getMessage());
	    }
	}


}
