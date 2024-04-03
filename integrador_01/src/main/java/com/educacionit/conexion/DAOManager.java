package com.educacionit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.excepciones.DBConexionException;
import com.educacionit.excepciones.DBManagerException;
import com.educacionit.interfaces.DAOInterface;
import com.educacionit.model.Pelicula;

public class DAOManager implements DAOInterface{
	
	private static final String URL = "jdbc:mysql://localhost:3306/peliculas_db";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

	@Override
	public void verificarYCrearTabla() throws DBManagerException{	
		String table = "peliculas";
		try(
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conn.createStatement();
			){
			
			String query = "CREATE TABLE IF NOT EXISTS " + table + " (" 
					+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
					+ "titulo VARCHAR(100) NOT NULL," 
					+ "url VARCHAR(255)," 
					+ "imagen_promocional VARCHAR(255),"
					+ "generos VARCHAR(255)"
					+ ")";
			
			statement.executeUpdate(query);			
			
		}catch(SQLException e) {
			throw new DBManagerException(DBConexionException.ERROR_3,
					"Error al verificar y crear la tabla: " + e.getMessage(), e);
		}
		
	}

	@Override
	public List<Pelicula> mostrarLasPeliculas() throws DBManagerException {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT * FROM peliculas";
        try (
        		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        		Statement statement = conn.createStatement();
        		ResultSet resultSet = statement.executeQuery(query)
        	) {

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String titulo = resultSet.getString("titulo");
                String url = resultSet.getString("url");
                String imagenPromocional = resultSet.getString("imagen_promocional");
                String generos = resultSet.getString("generos");

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
        String query = "INSERT INTO peliculas (titulo, url, imagen_promocional, generos) "
                            + "VALUES (?, ?, ?, ?)";
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getUrl());
            statement.setString(3, pelicula.getImagen_promocional());
            statement.setString(4, pelicula.getGeneros());

            statement.executeUpdate();
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
	        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        PreparedStatement statement = conn.prepareStatement(query)
	    ) {
	        statement.setInt(1, codigo);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                int codigoPelicula = resultSet.getInt("codigo");
	                String titulo = resultSet.getString("titulo");
	                String url = resultSet.getString("url");
	                String imagenPromocional = resultSet.getString("imagen_promocional");
	                String generos = resultSet.getString("generos");

	                pelicula = new Pelicula(codigoPelicula, titulo, url, imagenPromocional, generos);
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
	    String query = "SELECT * FROM peliculas WHERE generos LIKE ?";
	    try (
	        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        PreparedStatement statement = conn.prepareStatement(query)
	    ) {
	        statement.setString(1, "%" + genero + "%");
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int codigo = resultSet.getInt("codigo");
	                String titulo = resultSet.getString("titulo");
	                String url = resultSet.getString("url");
	                String imagenPromocional = resultSet.getString("imagen_promocional");
	                String generos = resultSet.getString("generos");

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
	        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        PreparedStatement statement = conn.prepareStatement(query)
	    ) {
	        statement.setString(1, "%" + titulo + "%");
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int codigo = resultSet.getInt("codigo");
	                String tituloPelicula = resultSet.getString("titulo");
	                String url = resultSet.getString("url");
	                String imagenPromocional = resultSet.getString("imagen_promocional");
	                String generos = resultSet.getString("generos");

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
        String query = "UPDATE peliculas SET titulo = ?, url = ?, imagen_promocional = ?, generos = ? WHERE codigo = ?";
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setString(1, pelicula.getTitulo());
            statement.setString(2, pelicula.getUrl());
            statement.setString(3, pelicula.getImagen_promocional());
            statement.setString(4, pelicula.getGeneros());
            statement.setInt(5, pelicula.getCodigo());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DBManagerException(DBManagerException.ERROR_5, 
                		"No se encontró ninguna película con el código proporcionado.");
            }
            System.out.println("Pelicula modificada correctamente.");

        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_7, 
            		"Error al modificar la película: " + e.getMessage(), e);
        }
    }


    @Override
    public void eliminarPelicula(Integer codigo) throws DBManagerException {
        String query = "DELETE FROM peliculas WHERE codigo = ?";
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setInt(1, codigo);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DBManagerException(DBManagerException.ERROR_8, 
                		"No se encontró ninguna película con el código proporcionado.");
            }
            System.out.println("Pelicula eliminada correctamente.");

        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_8, 
            		"Error al eliminar la película: " + e.getMessage(), e);
        }
    }


}
