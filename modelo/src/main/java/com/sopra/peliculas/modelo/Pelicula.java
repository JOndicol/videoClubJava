package com.sopra.peliculas.modelo;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "pelicula")
@Scope(value= "prototype")
public class Pelicula {
	
	private static AtomicInteger secuencia;
	private Integer identificador;
	private String titulo;
	private String director;
	private String sinopsis;
	private List<String> listaDeCategorias;
	
	static{
		secuencia = new AtomicInteger();
	}
	
	public Pelicula() {
		super();
		this.identificador = secuencia.incrementAndGet();
	}

	public Pelicula(String titulo, String director, String sinopsis,
			List<String> listaDeCategorias) {
		super();
		this.identificador = secuencia.incrementAndGet();
		this.titulo = titulo;
		this.director = director;
		this.sinopsis = sinopsis;
		this.listaDeCategorias = listaDeCategorias;
	}

	
	@Override
	public String toString() {
		return "Pelicula [identificador=" + identificador + ", titulo=" + titulo + ", director=" + director
				+ ", sinopsis=" + sinopsis + ", listaDeCategorias=" + listaDeCategorias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public List<String> getListaDeCategorias() {
		return listaDeCategorias;
	}

	public void setListaDeCategorias(List<String> listaDeCategorias) {
		this.listaDeCategorias = listaDeCategorias;
	}

	

	
	
		
}
