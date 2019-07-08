package com.sopra.peliculas.negocio;

import java.util.Collection;
import java.util.List;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;

import com.sopra.peliculas.dao.IPeliculaDao;
import com.sopra.peliculas.modelo.Categoria;
import com.sopra.peliculas.modelo.Pelicula;

public class GestorPeliculas {
	
	private IPeliculaDao<Integer, Pelicula> miDaoPeliculas;
	private Pelicula peliculaAInsertar;
	
	public GestorPeliculas() {
		super();
	}

	public void altaPelicula(String titulo, String director, String sinopsis,
							List<Categoria> listaDeCategorias, ApplicationContext context) {
		
		peliculaAInsertar = context.getBean("pelicula", Pelicula.class);
		peliculaAInsertar.setTitulo(titulo);
		peliculaAInsertar.setDirector(director);
		peliculaAInsertar.setSinopsis(sinopsis);
		peliculaAInsertar.setListaDeCategorias(listaDeCategorias);
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

	public IPeliculaDao<Integer, Pelicula> getMiDaoPeliculas() {
		return miDaoPeliculas;
	}

	public void setMiDaoPeliculas(IPeliculaDao<Integer, Pelicula> miDaoPeliculas) {
		this.miDaoPeliculas = miDaoPeliculas;
	}

	public Pelicula getPeliculaAInsertar() {
		return peliculaAInsertar;
	}

	public void setPeliculaAInsertar(Pelicula peliculaAInsertar) {
		this.peliculaAInsertar = peliculaAInsertar;
	}
	
	
}
