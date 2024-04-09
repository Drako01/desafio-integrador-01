package com.educacionit.model;

import java.util.Objects;
import java.util.List;

public class Pelicula {
    private Integer codigo;
    private String titulo;
    private String url;
    private String imagenPromocional;
    private List<Genero> generos;

    public Pelicula() {
    }

    public Pelicula(Integer codigo, String titulo, String url, String imagenPromocional, List<Genero> generos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.url = url;
        this.imagenPromocional = imagenPromocional;
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

    public String getImagenPromocional() {
        return imagenPromocional;
    }

    public void setImagenPromocional(String imagenPromocional) {
        this.imagenPromocional = imagenPromocional;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(codigo, pelicula.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                ", imagenPromocional='" + imagenPromocional + '\'' +
                ", generos=" + generos +
                '}';
    }
}
