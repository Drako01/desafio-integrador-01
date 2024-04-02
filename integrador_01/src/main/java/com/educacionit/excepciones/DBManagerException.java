package com.educacionit.excepciones;

public class DBManagerException extends Exception {
	private static final long serialVersionUID = 1L;

	private Integer error;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	public static final int ERROR_3 = 3;
	public static final int ERROR_4 = 4;
	public static final int ERROR_5 = 5;
	public static final int ERROR_6 = 6;
	public static final int ERROR_7 = 7;
	public static final int ERROR_8 = 8;

	public DBManagerException(Integer error) {
		super();
		this.error = error;
	}

	public DBManagerException(Integer error, String message) {
		super(message);
		this.error = error;
	}

	public DBManagerException(Integer error, Throwable cause) {
		super(cause);
		this.error = error;
	}

	public DBManagerException(Integer error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;

	}

	public Integer getErrorCode() {
		return error;
	}

	@Override
	public String getMessage() {
		switch (error) {
		case ERROR_1:
			return "Error al mostrar las Peliculas. \nError: " + super.getMessage();
		case ERROR_2:
			return "Error al obtener las Peliculas. \nError: " + super.getMessage();
		case ERROR_3:
			return "Error al mostrar la Pelicula. \nError: " + super.getMessage();
		case ERROR_4:
			return "Error al mostrar la Pelicula. \nError: " + super.getMessage();
		case ERROR_5:
			return "No Existe ese Nro de codigo. \nError: " + super.getMessage();
		case ERROR_6:
			return "No se pudo insertar la Pelicula. \nError: " + super.getMessage();
		case ERROR_7:
			return "Error al modificar la Pelicula. \nError: " + super.getMessage();
		case ERROR_8:
			return "Error al eliminar la Pelicula. \nError: " + super.getMessage();
		default:
			return super.getMessage();
		}
	}
}
