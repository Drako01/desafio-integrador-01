package com.educacionit.model;

import java.util.Objects;

public class Pelicula {

	private Integer codigo;
	private String titulo;
	private String url;
	private String imagen_promocional;
	private String generos;

	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelicula(Integer codigo, String titulo, String url, String imagen_promocional, String generos) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.url = url;
		this.imagen_promocional = imagen_promocional;
		this.generos = generos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImagen_promocional() {
		return imagen_promocional;
	}

	public void setImagen_promocional(String imagen_promocional) {
		this.imagen_promocional = imagen_promocional;
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", url=" + url + ", imagen_promocional="
				+ imagen_promocional + ", generos=" + generos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
