package com.sopra.peliculas.negocio;

import java.util.Collection;
import java.util.List;

import com.sopra.peliculas.dao.Factory;
import com.sopra.peliculas.dao.IPeliculaDao;
import com.sopra.peliculas.modelo.Categoria;
import com.sopra.peliculas.modelo.Pelicula;

public class GestorPeliculas {
	
	private IPeliculaDao<Integer, Pelicula> miDaoPeliculas;
	
	public GestorPeliculas() {
		super();
		this.miDaoPeliculas = Factory.getPeliculaDao();
	}

	public void altaPelicula(String titulo, String director, String sinopsis,
							List<Categoria> listaDeCategorias) {
		
		Pelicula peliculaAInsertar = new Pelicula(titulo, director, sinopsis, listaDeCategorias);
		miDaoPeliculas.createPelicula(peliculaAInsertar);
		
	}
	
	public Collection<Pelicula> listarPeliculas(){
		
		return miDaoPeliculas.read();
	}
	
	public void updatePelicula(List<Pelicula> peliculaAActualizar) {
		for(Pelicula pelicula: peliculaAActualizar) {
			miDaoPeliculas.updatePelicula(pelicula);
		}

	}
	
	public void deletePelicula(List<Integer> peliculasABorrarPorId) {
		for(int id: peliculasABorrarPorId) {
			miDaoPeliculas.deletePelicula(miDaoPeliculas.readById(id));
		}
	}
}
