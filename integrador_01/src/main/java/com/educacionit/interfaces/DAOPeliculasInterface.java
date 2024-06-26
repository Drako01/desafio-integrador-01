package com.educacionit.interfaces;

import java.util.List;

import com.educacionit.excepciones.DBManagerException;
import com.educacionit.model.Pelicula;

public interface DAOPeliculasInterface {
	
	public  List<Pelicula> mostrarLasPeliculas()throws DBManagerException;

	public void insertarPelicula(Pelicula pelicula)throws DBManagerException;

	public Pelicula obtenerPeliculaPorID(Integer codigo)throws DBManagerException;

	public List<Pelicula> buscarPeliculasPorGenero(String genero) throws DBManagerException;
	
	public List<Pelicula> buscarPeliculasPorTitulo(String titulo) throws DBManagerException;
	
	public void modificarPelicula(Pelicula pelicula)throws DBManagerException;

	public void eliminarPelicula(Integer codigo)throws DBManagerException;
}
