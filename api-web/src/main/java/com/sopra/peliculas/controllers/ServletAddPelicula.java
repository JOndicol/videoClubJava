package com.sopra.peliculas.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.peliculas.dao.PeliculasDaoImplemtacion;
import com.sopra.peliculas.modelo.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

/**
 * Servlet implementation class ServletAddPelicula
 */
@WebServlet({"/AddPelicula", "/AñadirPelicula"})
public class ServletAddPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static GestorPeliculas gestor;
	
	static {
		gestor = new GestorPeliculas();
		PeliculasDaoImplemtacion miDao = new PeliculasDaoImplemtacion();
		Map<Integer, Pelicula> miMapa = new HashMap<Integer, Pelicula>();
		miDao.setMapaPeliculas(miMapa);
		gestor.setMiDaoPeliculas(miDao);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddPelicula() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombreDeLaPelicula");
		String director = request.getParameter("directorDeLaPelicula");
		String sinopsis = request.getParameter("sinopsosDeLaPelicula");
		String[] categorias = request.getParameter("categorias").split(",");
		List<String> listaCategorias = new ArrayList<String>(Arrays.asList(categorias));
		Pelicula pelicula = new Pelicula();
		
		gestor.altaPelicula(nombre, director, sinopsis, listaCategorias, pelicula);
		response.getWriter().append("Agregada pelicula con campos: " + nombre + " " + director + " " + sinopsis);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
