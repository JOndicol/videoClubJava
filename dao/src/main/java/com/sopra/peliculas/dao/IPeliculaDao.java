package com.sopra.peliculas.dao;

import java.util.Collection;

import com.sopra.peliculas.modelo.Pelicula;

public interface IPeliculaDao<T,U> {
	
	public void createPelicula(U peliculaAInsertar);
	public void deletePelicula(U peliculaABorrar);
	public void updatePelicula(U peliculaAActualizar);
	public Pelicula readById(T identificador);
	public Collection<U> read();
	
}
