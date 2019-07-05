package com.sopra.peliculas.consola;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.peliculas.modelo.Categoria;
import com.sopra.peliculas.modelo.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

public class lanzador {
	
	
	public static void main(String[] args) {

		GestorPeliculas gestor = new GestorPeliculas();
		List<Categoria> listCat = new ArrayList<Categoria>();
		listCat.add(Categoria.DRAMA);
		listCat.add(Categoria.ACCION);
		
		for(int i = 0; i < 8; i++) {
			gestor.altaPelicula("Pepito", "Hulio", "Es increible", listCat);
		}
		
		List<Categoria> listLord = new ArrayList<Categoria>();
		listLord.add(Categoria.CIENCIA_FICCION);
		listLord.add(Categoria.ACCION);
		listLord.add(Categoria.TERROR);
		
		gestor.altaPelicula("The lord of the Rings", "Peter Jackson", "Best movie ever", listLord);
		
		List<Categoria> listStar = new ArrayList<Categoria>();
		listStar.add(Categoria.ACCION);
		listStar.add(Categoria.TERROR);
		
		gestor.altaPelicula("Starkid", "Bobinski", "Brrr", listStar);
		
		imprimirPeliculas(gestor.listarPeliculas());
		
		Pelicula peli1 = new Pelicula();
		Pelicula peli2 = new Pelicula();
		
		List<Categoria> listaCatActualizada = new ArrayList<Categoria>();
		listaCatActualizada.add(Categoria.DRAMA);
		listaCatActualizada.add(Categoria.TERROR);
		
		peli1.setDirector("Getilla");
		peli1.setSinopsis("Una trameadina al año no hace daño");
		peli1.setTitulo("Trameada con los constructores");
		peli1.setListaDeCategorias(listaCatActualizada);
		peli1.setIdentificador(5);
		
		peli2.setDirector("Getilla");
		peli2.setSinopsis("Una trameadina al año no hace daño");
		peli2.setTitulo("Trameada con los constructores");
		peli2.setListaDeCategorias(listaCatActualizada);
		peli2.setIdentificador(2);
		
		List<Pelicula> listaActual = new ArrayList<Pelicula>();
		listaActual.add(peli1);
		listaActual.add(peli2);
		
		gestor.updatePelicula(listaActual);
	
		imprimirPeliculas(gestor.listarPeliculas());
		
		List<Integer> listaDeletes = new ArrayList<Integer>();
		listaDeletes.add(2);
		listaDeletes.add(5);
		
		gestor.deletePelicula(listaDeletes);
		
		imprimirPeliculas(gestor.listarPeliculas());
	}
	
	public static void imprimirPeliculas(Collection<Pelicula> peliculas) {
		for(Pelicula pelicula: peliculas) {
			System.out.print(pelicula.getDirector() + " " + pelicula.getTitulo() + " " + pelicula.getListaDeCategorias());
		}
		System.out.println();
	}

}
