package com.educacionit.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConectionInterface {

	default Connection getConnection()  {

		try {
			final String URL = "jdbc:mysql://localhost:3306/peliculas_db";
			final String USER = "root";
			final String PASSWORD = "";
			
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			return conn ;
			
		} catch (SQLException sqlExcex) {
			sqlExcex.printStackTrace();
			return null;
		}
	}

}
