package com.sopra.peliculas.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sopra.peliculas.model.dao.IPeliculaDao;
import com.sopra.peliculas.model.entities.Pelicula;

@Configuration
public class ConfigVideoclub {
	@Bean
	public CommandLineRunner iniciarBaseDeDatos(IPeliculaDao almacen) {
		return args ->{
			almacen.save(new Pelicula("Interstellar","Nolan","Best movie 2017",Arrays.asList("Drama", "Thriller")));
			almacen.save(new Pelicula("Batman: Dark Knight rises","Nolan","Best movie 2016",Arrays.asList("Drama", "Thriller", "Accion")));
			almacen.save(new Pelicula("Las Dos Torres","Peter Jackson","La peor de la trilogia",Arrays.asList("Drama", "Thriller")));
		};
			
	}
}
