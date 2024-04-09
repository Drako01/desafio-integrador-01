package com.educacionit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.dao.DAOGenerosImplements;
import com.educacionit.model.Genero;

public class AgregarPeliculaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener la lista de géneros desde la base de datos
            DAOGenerosImplements daoGenerosManager = new DAOGenerosImplements();
            List<Genero> generos = daoGenerosManager.mostrarLosGeneros();
            
            // Establecer la lista de géneros como un atributo de solicitud
            request.setAttribute("generos", generos);
            
            // Redirigir al JSP agregarPelicula.jsp para mostrar el formulario con los géneros cargados
            request.getRequestDispatcher("/agregarPelicula.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error al cargar los géneros: " + e.getMessage());
        }
    }
}
