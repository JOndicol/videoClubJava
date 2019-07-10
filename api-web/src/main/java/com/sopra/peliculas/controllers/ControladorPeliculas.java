package com.sopra.peliculas.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sopra.peliculas.modelo.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

@Controller
@Scope("request")
public class ControladorPeliculas {
	@Autowired
	private GestorPeliculas gestor;
	
	@RequestMapping("home")
	public ModelAndView verFormulario() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("agregarPeliculas")
	public ModelAndView añadePeliculas(@RequestParam("nombre") String nombre, @RequestParam("director") String director, @RequestParam("sinopsis") String sinopsis, @RequestParam("categorias") String categorias, HttpServletRequest request) {
		
		String[] categoriasEnArray = categorias.split(",");
		List<String> listaCategorias = new ArrayList<String>(Arrays.asList(categoriasEnArray));
		this.gestor.altaPelicula(nombre, director, sinopsis, listaCategorias);
		
		ModelAndView modelAndView = new ModelAndView("muestraPelicula");
		modelAndView.addObject("pelicula", this.gestor.getPeliculaAInsertar());
		return modelAndView;

	}
	
	@RequestMapping("listarPeliculas")
	public ModelAndView listarPeliculas() {
		Collection<Pelicula> listaPeliculas = gestor.listarPeliculas();
		ModelAndView modelAndView = new ModelAndView("listaDePeliculasAñadidas");
		
		modelAndView.addObject("listaPeliculas", listaPeliculas);
		
		return modelAndView;
	}
}
