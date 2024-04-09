package com.educacionit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.excepciones.DBManagerException;
import com.educacionit.interfaces.ConectionInterface;
import com.educacionit.interfaces.DAOGenerosInterface;
import com.educacionit.model.Genero;

public class DAOGenerosImplements implements DAOGenerosInterface , ConectionInterface {
    
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
    public List<Genero> mostrarLosGeneros() throws DBManagerException {
        List<Genero> generos = new ArrayList<>();
        String query = "SELECT * FROM generos";
        try (
            Connection conn = getConnection(); 
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Genero genero = new Genero(id, nombre);
                generos.add(genero);
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, 
                    "Error al obtener los géneros: " + e.getMessage(), e);
        }
        return generos;
    }

    @Override
    public void insertarGenero(Genero genero) throws DBManagerException {
        String query = "INSERT INTO generos (nombre) VALUES (?)";
        try (
            Connection conn = getConnection(); 
            PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setString(1, genero.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_6, 
                    "Error al insertar el género: " + e.getMessage(), e);
        }
    }

    @Override
    public Genero obtenerGeneroPorID(Integer id) throws DBManagerException {
        Genero genero = null;
        String query = "SELECT * FROM generos WHERE id = ?";
        try (
            Connection conn = getConnection(); 
            PreparedStatement statement = conn.prepareStatement(query)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    genero = new Genero(id, nombre);
                }
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_4, 
                    "Error al obtener el género por su ID: " + e.getMessage(), e);
        }
        return genero;
    }
}
