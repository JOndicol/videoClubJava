package com.sopra.peliculas.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sopra.peliculas.modelo.Pelicula;
import com.sopra.peliculas.negocio.GestorPeliculas;

/**
 * Servlet implementation class ServletMostrarPeliculas
 */
@WebServlet("/mostrarPeliculas")
public class ServletMostrarPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext context;
    
	private static GestorPeliculas gestor;

	
	

	@Override
	public void init() throws ServletException {
		ServletMostrarPeliculas.context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gestor = context.getBean(GestorPeliculas.class);
		Collection<Pelicula> listaPeliculas = gestor.listarPeliculas();
		
		for(Pelicula pelicula: listaPeliculas) {
			response.getWriter().append("Peliculas: " + pelicula);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
