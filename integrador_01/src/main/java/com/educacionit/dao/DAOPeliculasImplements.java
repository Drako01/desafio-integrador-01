package com.educacionit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.excepciones.DBManagerException;
import com.educacionit.interfaces.ConectionInterface;
import com.educacionit.interfaces.DAOPeliculasInterface;
import com.educacionit.model.Genero;
import com.educacionit.model.Pelicula;

public class DAOPeliculasImplements implements DAOPeliculasInterface, ConectionInterface {	
	
	@Override
    public Connection getConnection() {
        return ConectionInterface.super.getConnection(); 
    }
	
	static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

	@Override
	public List<Pelicula> mostrarLasPeliculas() throws DBManagerException {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT * FROM peliculas";
        try (
        		Connection conn = getConnection(); 
        		Statement statement = conn.createStatement();
        		ResultSet resultSet = statement.executeQuery(query)
        	) {

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String titulo = resultSet.getString("titulo");
                String url = resultSet.getString("url");
                String imagenPromocional = resultSet.getString("imagen_promocional");
                
                // Obtengo los géneros asociados a la película
                List<Genero> generos = obtenerGenerosDePelicula(conn, codigo);

                Pelicula pelicula = new Pelicula(codigo, titulo, url, imagenPromocional, generos);
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, 
            		"Error al obtener las películas: " + e.getMessage(), e);
        }
        return peliculas;
    }

	@Override
	public void insertarPelicula(Pelicula pelicula) throws DBManagerException {
        String query = "INSERT INTO peliculas (titulo, url, imagen_promocional) "
                            + "VALUES (?, ?, ?)";
        try (
        	Connection conn = getConnection(); 
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getUrl());
            statement.setString(3, pelicula.getImagenPromocional());

            statement.executeUpdate();
            
            // Obtengo el código de la película insertada
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int codigo = generatedKeys.getInt(1);
                pelicula.setCodigo(codigo);
            }
            
            // Inserto los géneros asociados a la película
            insertarGenerosDePelicula(conn, pelicula);

        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_6, 
            		"Error al insertar la película: " + e.getMessage(), e);
        }
    }

	@Override
	public Pelicula obtenerPeliculaPorID(Integer codigo) throws DBManagerException {
	    Pelicula pelicula = null;
	    String query = "SELECT * FROM peliculas WHERE codigo = ?";
	    try (
	    	Connection conn = getConnection(); 
	        PreparedStatement statement = conn.prepareStatement(query)
	    ) {
	        statement.setInt(1, codigo);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                String titulo = resultSet.getString("titulo");
	                String url = resultSet.getString("url");
	                String imagenPromocional = resultSet.getString("imagen_promocional");
	                
	                // Obtengo los géneros asociados a la película
	                List<Genero> generos = obtenerGenerosDePelicula(conn, codigo);

	                pelicula = new Pelicula(codigo, titulo, url, imagenPromocional, generos);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DBManagerException(DBManagerException.ERROR_4, 
	        		"Error al obtener la película por su ID: " + e.getMessage(), e);
	    }
	    return pelicula;
	}

	@Override
	public List<Pelicula> buscarPeliculasPorGenero(String genero) throws DBManagerException {
	    List<Pelicula> peliculas = new ArrayList<>();
	    String query = "SELECT p.* FROM peliculas p INNER JOIN pelicula_genero pg ON p.codigo = pg.id_pelicula"
	    				+ " INNER JOIN generos g ON pg.id_genero = g.id WHERE g.nombre LIKE ?";
	    try (
	    		Connection conn = getConnection(); 
	    		PreparedStatement statement = conn.prepareStatement(query)
	    ) {
	        statement.setString(1, "%" + genero + "%");
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int codigo = resultSet.getInt("codigo");
	                String titulo = resultSet.getString("titulo");
	                String url = resultSet.getString("url");
	                String imagenPromocional = resultSet.getString("imagen_promocional");
	                
	                // Obtengo los géneros asociados a la película
	                List<Genero> generos = obtenerGenerosDePelicula(conn, codigo);

	                Pelicula pelicula = new Pelicula(codigo, titulo, url, imagenPromocional, generos);
	                peliculas.add(pelicula);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DBManagerException(DBManagerException.ERROR_2, 
	            "Error al obtener las películas por género: " + e.getMessage(), e);
	    }
	    return peliculas;
	}

	@Override
	public List<Pelicula> buscarPeliculasPorTitulo(String titulo) throws DBManagerException {
	    List<Pelicula> peliculas = new ArrayList<>();
	    String query = "SELECT * FROM peliculas WHERE titulo LIKE ?";
	    try (
	    	Connection conn = getConnection(); 
	        PreparedStatement statement = conn.prepareStatement(query)
	    ) {
	        statement.setString(1, "%" + titulo + "%");
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int codigo = resultSet.getInt("codigo");
	                String tituloPelicula = resultSet.getString("titulo");
	                String url = resultSet.getString("url");
	                String imagenPromocional = resultSet.getString("imagen_promocional");
	                
	                // Obtengo los géneros asociados a la película
	                List<Genero> generos = obtenerGenerosDePelicula(conn, codigo);

	                Pelicula pelicula = new Pelicula(codigo, tituloPelicula, url, imagenPromocional, generos);
	                peliculas.add(pelicula);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DBManagerException(DBManagerException.ERROR_2, 
	            "Error al obtener las películas por título: " + e.getMessage(), e);
	    }
	    return peliculas;
	}
  
    @Override
    public void modificarPelicula(Pelicula pelicula) throws DBManagerException {
        String query = "UPDATE peliculas SET titulo = ?, url = ?, imagen_promocional = ? WHERE codigo = ?";
        try (
        	Connection conn = getConnection(); 
            PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getUrl());
            statement.setString(3, pelicula.getImagenPromocional());
            statement.setInt(4, pelicula.getCodigo());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DBManagerException(DBManagerException.ERROR_5, 
                		"No se encontró ninguna película con el código proporcionado.");
            }
            
            // Actualizo los géneros asociados a la película
            actualizarGenerosDePelicula(conn, pelicula);

        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_7, 
            		"Error al modificar la película: " + e.getMessage(), e);
        }
    }


    @Override
    public void eliminarPelicula(Integer codigo) throws DBManagerException {
        try (
        		Connection conn = getConnection()) 
        {
            // Elimino primero los registros asociados en la tabla pelicula_genero
            eliminarGenerosDePelicula(conn, codigo);

            // Luego elimina la película
            String query = "DELETE FROM peliculas WHERE codigo = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, codigo);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected == 0) {
                    throw new DBManagerException(DBManagerException.ERROR_8, "No se encontró ninguna película con el código proporcionado.");
                }
               
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_8, "Error al eliminar la película: " + e.getMessage(), e);
        }
    }

    // Método auxiliar para eliminar los registros asociados en la tabla pelicula_genero
    private void eliminarGenerosDePelicula(Connection conn, Integer codigoPelicula) throws SQLException {
        String deleteQuery = "DELETE FROM pelicula_genero WHERE id_pelicula = ?";
        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, codigoPelicula);
            deleteStatement.executeUpdate();
        }
    }


    // Método auxiliar para insertar los géneros asociados a una película
    private void insertarGenerosDePelicula(Connection conn, Pelicula pelicula) throws SQLException {
        String query = "INSERT INTO pelicula_genero (id_pelicula, id_genero) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (Genero genero : pelicula.getGeneros()) {
                statement.setInt(1, pelicula.getCodigo());
                statement.setInt(2, genero.getId());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    // Método auxiliar para obtener los géneros asociados a una película
    private List<Genero> obtenerGenerosDePelicula(Connection conn, Integer codigoPelicula) throws SQLException {
        List<Genero> generos = new ArrayList<>();
        String query = "SELECT g.* FROM generos g INNER JOIN pelicula_genero pg ON g.id = pg.id_genero WHERE pg.id_pelicula = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, codigoPelicula);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    Genero genero = new Genero(id, nombre);
                    generos.add(genero);
                }
            }
        }
        return generos;
    }

    // Método auxiliar para actualizar los géneros asociados a una película
    private void actualizarGenerosDePelicula(Connection conn, Pelicula pelicula) throws SQLException {
        String deleteQuery = "DELETE FROM pelicula_genero WHERE id_pelicula = ?";
        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, pelicula.getCodigo());
            deleteStatement.executeUpdate();
        }
        insertarGenerosDePelicula(conn, pelicula);
    }
}
