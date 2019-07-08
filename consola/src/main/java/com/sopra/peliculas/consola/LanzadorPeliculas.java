package com.sopra.peliculas.consola;

import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sopra.peliculas.modelo.Categoria;
import com.sopra.peliculas.modelo.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

public class LanzadorPeliculas {
	
	private static ApplicationContext context;
	
	static {
		context  = new ClassPathXmlApplicationContext("bean_bussiness.xml");
	}
	
	public static void main(String[] args) {

		
		GestorPeliculas gestor = context.getBean("miGestionDePeliculas", GestorPeliculas.class);
		List<Categoria> listCat = context.getBean("listaArray", List.class);
		listCat.add(Categoria.DRAMA);
		listCat.add(Categoria.ACCION);

		for(int i = 0; i < 8; i++) {
			gestor.altaPelicula("Pepito", "Hulio", "Es increible", listCat, context);
		}
		
		List<Categoria> listLord = context.getBean("listaArray", List.class);
		listLord.add(Categoria.CIENCIA_FICCION);
		listLord.add(Categoria.ACCION);
		listLord.add(Categoria.TERROR);
		
		gestor.altaPelicula("The lord of the Rings", "Peter Jackson", "Best movie ever", listLord, context);
		
		List<Categoria> listStar = context.getBean("listaArray", List.class);
		listStar.add(Categoria.ACCION);
		listStar.add(Categoria.TERROR);
		
		gestor.altaPelicula("Starkid", "Bobinski", "Brrr", listStar, context);
		
		imprimirPeliculas(gestor.listarPeliculas());
		
		Pelicula peli1 = context.getBean("pelicula", Pelicula.class);
		Pelicula peli2 = context.getBean("pelicula", Pelicula.class);
		
		List<Categoria> listaCatActualizada = context.getBean("listaArray", List.class);
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
		
		List<Pelicula> listaActual = context.getBean("listaArray", List.class);
		listaActual.add(peli1);
		listaActual.add(peli2);
		
		gestor.updatePelicula(listaActual);
	
		imprimirPeliculas(gestor.listarPeliculas());
		
		List<Integer> listaDeletes = context.getBean("listaArray", List.class);
		listaDeletes.add(2);
		listaDeletes.add(5);
		
		gestor.deletePelicula(listaDeletes);
		
		imprimirPeliculas(gestor.listarPeliculas());
		((AbstractApplicationContext)context).close();
	}
	
	public static void imprimirPeliculas(Collection<Pelicula> peliculas) {
		for(Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		System.out.println();
	}

}
