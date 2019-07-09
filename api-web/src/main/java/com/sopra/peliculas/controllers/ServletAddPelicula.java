package com.sopra.peliculas.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sopra.peliculas.negocio.GestorPeliculas;

/**
 * Servlet implementation class ServletAddPelicula
 */
@WebServlet({"/AddPelicula", "/AñadirPelicula"})
public class ServletAddPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ApplicationContext context;
       
	private static GestorPeliculas gestor;
	

	@Override
	public void init() throws ServletException {
		ServletAddPelicula.context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gestor = context.getBean(GestorPeliculas.class);
		String nombre = request.getParameter("nombreDeLaPelicula");
		String director = request.getParameter("directorDeLaPelicula");
		String sinopsis = request.getParameter("sinopsosDeLaPelicula");
		String[] categorias = request.getParameter("categorias").split(",");
		List<String> listaCategorias = new ArrayList<String>(Arrays.asList(categorias));
		
		gestor.altaPelicula(nombre, director, sinopsis, listaCategorias);
		response.getWriter().append("Agregada pelicula con campos: " + nombre + " " + director + " " + sinopsis);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
