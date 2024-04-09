package com.educacionit.interfaces;

import java.util.List;

import com.educacionit.excepciones.DBManagerException;
import com.educacionit.model.Genero;

public interface DAOGenerosInterface {
	
	public  List<Genero> mostrarLosGeneros() throws DBManagerException;

	public void insertarGenero(Genero genero) throws DBManagerException;

	public Genero obtenerGeneroPorID(Integer id) throws DBManagerException;
}
