package com.atrium.master.services;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atrium.master.pojos.Libro;
import com.atrium.master.services.helper.LibroJDBCTest;
import com.atrium.master.services.helper.PojosJDBCTest.LibroPojoJDBCTest;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class LibrosHibernateBOTest {

	@Before
	public void inicializar() {
		libroPojoJDBCTest.setAutor("AutorTest");
		libroPojoJDBCTest.setIsb("155541654");
		libroPojoJDBCTest.setSipnosis("El primer libro en los test");
		libroPojoJDBCTest.setTitulo("Titulo Test");

	}

	@Inject
	private LibrosHibernateBO gestorLibrosHibernate;
	@Inject
	private LibroJDBCTest gestorLibrosJDBC;
	@Inject
	private Libro libroTest;
	@Inject
	private LibroPojoJDBCTest libroPojoJDBCTest;

	@Test
	public void insertar_libro() {
		libroTest = new Libro("1", "Libro de prueba 1", "Autor 1",
				"El libro 1 es muy feo");
		Long identificador = gestorLibrosHibernate.createLibro(libroTest);
		assertNotNull(identificador);

		gestorLibrosJDBC.deleteById(identificador, "Libros");

	}

	@Test
	public void buscar_Libro_por_Id() {
		Long id = gestorLibrosJDBC.save(libroPojoJDBCTest, "Libros");

		libroTest = gestorLibrosHibernate.findLibroById(id);

		assertNotNull(libroTest);
		assertEquals("155541654", libroTest.getIsb());

		gestorLibrosJDBC.deleteById(id, "Libros");

	}

	@Test
	public void obtener_todos_libros_disponibles() {
		Long id=gestorLibrosJDBC.save(libroPojoJDBCTest, "Libros");

		List<Libro> listadoLibrosDisponibles = new LinkedList<Libro>();
		listadoLibrosDisponibles = gestorLibrosHibernate.listAll();

		assertNotNull(listadoLibrosDisponibles);
		assertTrue(listadoLibrosDisponibles.size() > 0);
		
		 gestorLibrosJDBC.deleteById(id, "Libros");
	}

	@Test
	public void modificar_los_datos_de_un_libro() {
		Long id = gestorLibrosJDBC.save(libroPojoJDBCTest, "Libros");

		libroTest = new Libro(id, "155541654", "Titulo Test", "Pepito",
				"El primer libro en los test");
		gestorLibrosHibernate.update(libroTest);

		LibroPojoJDBCTest libroPojoJDBCAux = gestorLibrosJDBC.getById(id,
				"Libros");

		assertEquals("El valor del Autor no es correto", "Pepito",
				libroPojoJDBCAux.getAutor());
		
		gestorLibrosJDBC.deleteById(id, "Libros");

	}

	@Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
	public void borrar_libro() {

		Long id = gestorLibrosJDBC.save(libroPojoJDBCTest, "Libros");

		libroTest = new Libro(id, "155541654", "Titulo Test", "AutorTest",
				"El primer libro en los test");
		gestorLibrosHibernate.delete(libroTest);

		gestorLibrosJDBC.getById(id, "Libros");

	}
}
