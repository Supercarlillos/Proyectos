package com.atrium.master.services;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atrium.master.pojos.Libro;
import com.atrium.master.services.helper.LibroTest;


@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class GestorLibrosHibernateTest {

	@Inject
	private LibrosHibernateBO gestorLibrosHibernate;
	
	@Inject
	private LibroTest gestorLibrosJDBC;

	@Inject
	private Libro libroTest;

	@Test
	public void insertar_libro() {
		Libro libroTest = new Libro("1", "Libro de prueba 1", "Autor 1",
				"El libro 1 es muy feo");

		assertNotNull(gestorLibrosHibernate.createLibro(libroTest));

	}

	@Test
	public void buscar_Libro_por_Id(){
		//TODO I should insert a Person directly with SQL (use JdbcTemplate)
		libroTest.setAutor("AutorTest");
		libroTest.setIsb("155541654");
		libroTest.setSipnosis("El primer libro en los test");
		libroTest.setTitulo("Titulo Test");
		
		Long id=gestorLibrosJDBC.save(libroTest);
		
		Libro libroAux = gestorLibrosHibernate.findLibroById(id);
		
		assertNotNull(libroAux);
		assertEquals("155541654",libroAux.getIsb());
		
		
	}
}
