package com.sopra.peliculas.dao;

import java.util.Collection;
import java.util.Map;

import com.sopra.peliculas.modelo.Pelicula;

public class PeliculasDaoImplemtacion implements IPeliculaDao<Integer, Pelicula>{
	
	private Map<Integer, Pelicula> listaPeliculas;
	
	

	public PeliculasDaoImplemtacion(Map<Integer, Pelicula> listaPeliculas) {
		super();
		this.listaPeliculas = listaPeliculas;
	}

	@Override
	public void createPelicula(Pelicula peliculaAInsertar) {
		listaPeliculas.putIfAbsent(peliculaAInsertar.getIdentificador(), peliculaAInsertar);	
	}

	@Override
	public void deletePelicula(Pelicula peliculaABorrar) {
		listaPeliculas.remove(peliculaABorrar.getIdentificador());
	}

	@Override
	public void updatePelicula(Pelicula peliculaAActualizar) {
		listaPeliculas.replace(peliculaAActualizar.getIdentificador(), peliculaAActualizar);
		
	}

	@Override
	public Pelicula readById(Integer identificador) {
		return listaPeliculas.get(identificador);
	}

	@Override
	public Collection<Pelicula> read() {
		return listaPeliculas.values();
	}



}
