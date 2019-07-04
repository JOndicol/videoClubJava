package com.sopra.peliculas.dao;

import java.util.HashMap;

import com.sopra.peliculas.modelo.Pelicula;

public class Factory {
	
	private static IPeliculaDao<Integer, Pelicula> peliculaDao;
	
	public static IPeliculaDao<Integer, Pelicula> getPeliculaDao(){
		if(peliculaDao== null) {
			peliculaDao= new PeliculasDaoImplemtacion(new HashMap<Integer, Pelicula>());
		}
		return peliculaDao;
	}
	
}
