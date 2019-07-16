package com.sopra.balance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sopra.peliculas.model.entities.Pelicula;

@Controller
public class ControladorDePeliculas {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("peliculaActualizada", new Pelicula());
		return "pelicula";		
	}
	
	
	@RequestMapping("/listadoDePeliculas")
	public String listadoDePeliculas(Model model) {
		String urlDeAccesoAlServicio = "http://videoClubJava/listarPeliculas";
		ResponseEntity<List> respuestaDelServidor = restTemplate.exchange(urlDeAccesoAlServicio, HttpMethod.GET, null, List.class);
		List listaPeliculas = respuestaDelServidor.getBody();
		model.addAttribute("peliculas", listaPeliculas);
		return "listadoDePeliculas";
	}
	
	@RequestMapping("/nuevaPelicula")
	public String altaPelicula(@RequestParam("titulo") String titulo, 
			@RequestParam("director") String director, @RequestParam("sinopsis") String sinopsis,
			@RequestParam("listaDeCategorias") List<String> listaDeCategorias ,Model model) {
		String urlDeAccesoAlServicio = "http://videoClubJava/insertarPelicula";
		Pelicula pelicula = new Pelicula(titulo, director, sinopsis, listaDeCategorias);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Pelicula> entidadAEnviar = new HttpEntity<Pelicula>(pelicula, headers);
		ResponseEntity<Pelicula> entity = restTemplate.exchange(urlDeAccesoAlServicio, HttpMethod.POST,entidadAEnviar,Pelicula.class);
		
		model.addAttribute("peliculaActualizada",new Pelicula());
		Pelicula peliculaAlmacenada = entity.getBody();
		model.addAttribute("pelicula", peliculaAlmacenada);
		return "pelicula";
	}
	
	@RequestMapping("/modificarPelicula")
	public String modificarPelicula(@RequestParam("identificador") Integer id, @RequestParam("titulo") String titulo, 
			@RequestParam("director") String director, @RequestParam("sinopsis") String sinopsis,
			@RequestParam("listaDeCategorias") List<String> listaDeCategorias ,Model model) {
		
		String urlDeAccesoAlServicio = "http://videoClubJava/actualizarOEspecificarPelicula/" + id;
		Pelicula pelicula = new Pelicula(titulo, director, sinopsis, listaDeCategorias);
		pelicula.setIdentificador(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Pelicula> entidadAEnviar = new HttpEntity<Pelicula>(pelicula, headers);
		ResponseEntity<Pelicula> entity = restTemplate.exchange(urlDeAccesoAlServicio, HttpMethod.PUT,entidadAEnviar,Pelicula.class);
		
		Pelicula peliculaAlmacenada = entity.getBody();
		model.addAttribute("pelicula",new Pelicula());
		model.addAttribute("peliculaActualizada", peliculaAlmacenada);

		return "pelicula";
		
	}
	
	@RequestMapping("/eliminarPelicula/{id}")
	public String eliminarPelicula(@PathVariable Integer id, Model model) {
		String urlDeAccesoAlServicio = "http://videoClubJava/eliminarPeliculaPorId/" + id;
		restTemplate.delete(urlDeAccesoAlServicio);
		return "peliculaEliminada";
	}
}
