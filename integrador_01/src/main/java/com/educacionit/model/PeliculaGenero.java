package com.educacionit.model;

import java.util.Objects;

public class PeliculaGenero {
    private Integer idPelicula;
    private Integer idGenero;

    public PeliculaGenero() {
    }

    public PeliculaGenero(Integer idPelicula, Integer idGenero) {
        this.idPelicula = idPelicula;
        this.idGenero = idGenero;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaGenero that = (PeliculaGenero) o;
        return Objects.equals(idPelicula, that.idPelicula) &&
                Objects.equals(idGenero, that.idGenero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idGenero);
    }

    @Override
    public String toString() {
        return "PeliculaGenero{" +
                "idPelicula=" + idPelicula +
                ", idGenero=" + idGenero +
                '}';
    }
}
