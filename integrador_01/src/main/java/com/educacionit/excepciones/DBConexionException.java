package com.educacionit.excepciones;

public class DBConexionException extends Exception {
	private static final long serialVersionUID = 1L;

	private Integer error;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	public static final int ERROR_3 = 3;
	public static final int ERROR_4 = 4;

	public DBConexionException(Integer error) {
		super();
		this.error = error;
	}

	public DBConexionException(Integer error, String message) {
		super(message);
		this.error = error;
	}

	public DBConexionException(Integer error, Throwable cause) {
		super(cause);
		this.error = error;
	}

	public DBConexionException(Integer error, String message, Throwable cause) {
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
			return "La conexión a la Base de datos Falló. \nError: " + super.getMessage();
		case ERROR_2:
			return "La Base de Datos No Existe. \nError: " + super.getMessage();
		case ERROR_3:
			return "La Tabla solicitada No Existe. \nError: " + super.getMessage();
		case ERROR_4:
			return "No se pudo Desconectar de la Base de datos. \nError: " + super.getMessage();
		default:
			return super.getMessage();
		}
	}
}
