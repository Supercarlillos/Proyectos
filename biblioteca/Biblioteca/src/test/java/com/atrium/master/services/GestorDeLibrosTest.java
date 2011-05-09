package com.atrium.master.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atrium.master.modelo.Libro;

//Permite cargar el contexto de Spring directamente en el Test
@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class GestorDeLibrosTest {

	@Before
	public void inicializar() {
		// libroDummy.setAutor(null);
		// libroDummy.setIdentificador(null);
		// libroDummy.setIsb(null);
		// libroDummy.setSipnosis(null);
		// libroDummy.setTitulo(null);
	}

	@Inject
	private GestorDeLibrosBO gestorDeLibros;

	@Inject
	private Libro libroDummy;

	@Test
	public void obtener_libro_por_identificador() {
		// Arrange

		// Act
		libroDummy = gestorDeLibros.obtenerLibroPorId(1l);

		// Asserts
		System.out.println(libroDummy);
		assertNotNull(libroDummy);
	}

	@Test
	public void listado_de_libros_disponibles() {
		// Arrange

		// Act
		List<Libro> listadoLibrosDisponibles = new ArrayList<Libro>();
		listadoLibrosDisponibles = gestorDeLibros
				.obtenerListadoLibrosDisponibles();

		// Asserts
		System.out.println(gestorDeLibros.obtenerListadoLibrosDisponibles());
		assertNotNull(listadoLibrosDisponibles);
		assertEquals(
				"El tamaño del vector de los libros disponibles no es válido: ",
				3, listadoLibrosDisponibles.size());
	}

	@Test
	public void agrega_libro_nuevo() {
		// Arrange

		// Act
		libroDummy.setIsb("0000000000005");
		libroDummy.setTitulo("EjemplolibroNuevo");
		libroDummy.setAutor("Perez reverte");
		libroDummy.setSipnosis("un libro en sí");
		// Asserts
		assertNotNull(gestorDeLibros.agregarLibroNuevo(libroDummy)
				.getIdentificador());
		List<Libro> listadoLibrosDisponibles = new ArrayList<Libro>();
		listadoLibrosDisponibles = gestorDeLibros
				.obtenerListadoLibrosDisponibles();
		assertEquals("No ha aumentado número de libros disponibles", 4,
				listadoLibrosDisponibles.size());
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void agrega_libro_nuevo_faltando_algun_campo_devuelve_exception() {
		// Arrange
		libroDummy.setIsb("0000000000029");
		libroDummy.setAutor("Lupin");
		libroDummy.setSipnosis("un libro en sí");

		// Act
		// Asserts
		gestorDeLibros.agregarLibroNuevo(libroDummy);
	}

	@Test
	public void modifica_datos_de_libro() {
		// Arrange
		libroDummy.setIdentificador(1l);
		libroDummy.setIsb("0000000000009");
		libroDummy.setTitulo("EjemplolibroModificado");
		libroDummy.setAutor("Emilio Butrageño");
		libroDummy.setSipnosis("un libro en sí");

		// Act

		// Asserts
		assertTrue(libroDummy.equals(gestorDeLibros
				.modificarDatosLibro(libroDummy)));
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void modifica_datos_de_libro_falta_algun_dato() {
		// Arrange
		// libroDummy.setIdentificador(1);
		libroDummy.setIsb("0000000000005");
		libroDummy.setAutor("Emilio Butrageño");
		libroDummy.setSipnosis("un libro en sí");

		// Act

		// Asserts
		gestorDeLibros.modificarDatosLibro(libroDummy);
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void modifica_datos_de_libro_no_existe_libro() {
		// Arrange
		// Arrange
		// libroDummy.setIdentificador(10);
		libroDummy.setIsb("0000000000005");
		libroDummy.setTitulo("EjemplolibroNuevo");
		libroDummy.setAutor("Emilio Butrageño");
		libroDummy.setSipnosis("un libro en sí");

		// Act

		// Asserts
		gestorDeLibros.modificarDatosLibro(libroDummy);
	}

	@Test
	public void borrado_libro_identificador() {
		// Arrange
		// Act

		// Asserts
		assertEquals("No se ha borrado las filas correctas",
				gestorDeLibros.borrarLibroPorId(4l), 1);
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void borrado_libro_no_existe_libro() {
		// Arrange
		// libroDummy.setIdentificador(10);
		libroDummy.setIsb("0000000000005");
		libroDummy.setTitulo("EjemplolibroNuevo");
		libroDummy.setAutor("Emilio Butrageño");
		libroDummy.setSipnosis("un libro en sí");

		// Act

		// Asserts
		gestorDeLibros.borrarLibroPorId(10l);
	}
}
