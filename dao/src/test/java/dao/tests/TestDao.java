package dao.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sopra.peliculas.dao.PeliculasDaoImplemtacion;
import com.sopra.peliculas.modelo.Pelicula;

public class TestDao {
	
	private static PeliculasDaoImplemtacion daoTesting;
	
	@Before
	public void inicializar() {
		System.out.println("Iniciando Tests----------------------");
		daoTesting = new PeliculasDaoImplemtacion();
		daoTesting.setMapaPeliculas(new HashMap<Integer, Pelicula>());
	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void crearPeliculaNula() {
		Pelicula pelicula = null;
		daoTesting.createPelicula(pelicula);
	}
	
	@Test
	public void crearPeliculaNormal() {
		Pelicula pelicula = new Pelicula();
		daoTesting.createPelicula(pelicula);
		assertTrue("Comprobando que coinciden", daoTesting.getMapaPeliculas().get(pelicula.getIdentificador()).equals(pelicula));
	}
	
	@Test
	public void eliminarPeliculaNormal() {
		Pelicula pelicula = new Pelicula();
		daoTesting.createPelicula(pelicula);
		daoTesting.deletePelicula(pelicula);
		assertFalse("Comprobando que existe", daoTesting.getMapaPeliculas().containsKey(pelicula.getIdentificador()));
	}
	@Test
	public void eliminarPeliculaNoExistente() {
		Pelicula pelicula = new Pelicula();
		int size = daoTesting.getMapaPeliculas().size();
		daoTesting.deletePelicula(pelicula);
		assertTrue("Comprobando que no elimina nada", daoTesting.getMapaPeliculas().size()==size);
	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void eliminarPeliculaNula() {
		Pelicula pelicula = null;
		daoTesting.deletePelicula(pelicula);
	}
	@Test
	public void listarPeliculasNormal() {
		Collection<Pelicula> collection = daoTesting.read();
		for(Pelicula pelicula: collection) {
			assertTrue("Comprobando que coinciden", daoTesting.getMapaPeliculas().containsKey(pelicula.getIdentificador()));
		}
	}
	
	@Test
	public void leerPorIdNormal() {
		Pelicula pelicula = new Pelicula();
		daoTesting.createPelicula(pelicula);
		assertTrue("Comprobando que existe", daoTesting.readById(pelicula.getIdentificador()).equals(pelicula));
	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void leerPorIdNula() {
		assertTrue("Comprobando que existe", daoTesting.readById(37).equals(null));
	}
	@Test
	public void updatePeliculaNormal() {
		Pelicula pelicula = new Pelicula();
		daoTesting.createPelicula(pelicula);
		Pelicula peliculaUpdatear = new Pelicula();
		peliculaUpdatear.setIdentificador(pelicula.getIdentificador());
		peliculaUpdatear.setDirector("Lambo");
		daoTesting.updatePelicula(peliculaUpdatear);
		assertTrue("Comprobando que actualiza", daoTesting.getMapaPeliculas().get(pelicula.getIdentificador()).getDirector().equals("Lambo"));
	}
	
	@Test
	public void updatePeliculaNoExistente() {
		Pelicula pelicula = new Pelicula();
		daoTesting.createPelicula(pelicula);
		pelicula.setDirector("NoLambo");
		Pelicula peliculaUpdatear = new Pelicula();
		peliculaUpdatear.setDirector("Lambo");
		daoTesting.updatePelicula(peliculaUpdatear);
		assertTrue("Comprobando que NO actualiza", daoTesting.getMapaPeliculas().get(pelicula.getIdentificador()).getDirector().equals("NoLambo"));
	}
	
    @After
    public void terminar() {
    	System.out.println("Finalizando pruebas-----------");
    }
}
