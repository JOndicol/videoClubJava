package com.sopra.peliculas.dao;

import java.util.Collection;
import java.util.Map;

import com.sopra.peliculas.modelo.Pelicula;

public class PeliculasDaoImplemtacion implements IPeliculaDao<Integer, Pelicula>{
	
	private Map<Integer, Pelicula> mapaPeliculas;
	
	public PeliculasDaoImplemtacion() {
		super();
	}

	@Override
	public void createPelicula(Pelicula peliculaAInsertar) {
		mapaPeliculas.putIfAbsent(peliculaAInsertar.getIdentificador(), peliculaAInsertar);	
	}

	@Override
	public void deletePelicula(Pelicula peliculaABorrar) {
		mapaPeliculas.remove(peliculaABorrar.getIdentificador());
	}

	@Override
	public void updatePelicula(Pelicula peliculaAActualizar) {
		mapaPeliculas.replace(peliculaAActualizar.getIdentificador(), peliculaAActualizar);
		
	}

	@Override
	public Pelicula readById(Integer identificador) {
		return mapaPeliculas.get(identificador);
	}

	@Override
	public Collection<Pelicula> read() {
		return mapaPeliculas.values();
	}

	public Map<Integer, Pelicula> getMapaPeliculas() {
		return mapaPeliculas;
	}

	public void setMapaPeliculas(Map<Integer, Pelicula> mapaPeliculas) {
		this.mapaPeliculas = mapaPeliculas;
	}
	
	

}
