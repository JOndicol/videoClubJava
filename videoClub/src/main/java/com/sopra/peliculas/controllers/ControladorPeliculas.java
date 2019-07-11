package com.sopra.peliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.peliculas.model.dao.IPeliculaDao;
import com.sopra.peliculas.model.entities.Pelicula;

@RestController
public class ControladorPeliculas {
	
	@Autowired
	private IPeliculaDao almacen;
	
	

	public ControladorPeliculas() {
		super();
	}

	public ControladorPeliculas(IPeliculaDao almacen) {
		super();
		this.almacen = almacen;
	}

	@GetMapping("/listarPeliculas")
	public List<Pelicula> listaPeliculas(){
		return almacen.findAll();
	}
	
	@GetMapping("/peliculaPorId/{id}")
	public Pelicula peliculaById(@PathVariable Integer id) {
		return almacen.findById(id).orElse(null);
	}
	
	@PostMapping("/insertarPelicula")
	public Pelicula agregarPeliculaAlClub(@RequestBody Pelicula pelicula) {
		return almacen.save(pelicula);
	}
	
	@PutMapping("/actualizarOEspecificarPelicula/{id}")
	public Pelicula actualizarPelicula(@RequestBody Pelicula pelicula, @PathVariable Integer id) {
		return almacen.findById(id).map(clienteencontrado -> {
			clienteencontrado.setTitulo(pelicula.getTitulo());
			clienteencontrado.setDirector(pelicula.getDirector());
			clienteencontrado.setSinopsis(pelicula.getSinopsis());
			clienteencontrado.setListaDeCategorias(pelicula.getListaDeCategorias());
			return almacen.save(clienteencontrado);
		}).orElseGet(() -> {
			pelicula.setIdentificador(id);
			return almacen.save(pelicula);
		});
	}
	
	@DeleteMapping("/eliminarPeliculaPorId/{id}")
	public void venderArma(@PathVariable Integer id) {
		almacen.deleteById(id);
	}

	public IPeliculaDao getAlmacen() {
		return almacen;
	}

	public void setAlmacen(IPeliculaDao almacen) {
		this.almacen = almacen;
	}

}
