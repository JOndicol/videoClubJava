package com.sopra.peliculas.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sopra.peliculas.modelo.Pelicula;

@Repository
public class PeliculasDaoImplemtacion implements IPeliculaDao<Integer, Pelicula>{
	
	@Autowired
	@Qualifier("hashMapPelis")
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
