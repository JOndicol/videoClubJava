package com.sopra.peliculas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.peliculas.model.entities.Pelicula;

public interface IPeliculaDao extends JpaRepository<Pelicula, Integer>{

}
