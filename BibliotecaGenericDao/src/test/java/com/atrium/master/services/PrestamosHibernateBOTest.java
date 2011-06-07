package com.atrium.master.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atrium.master.pojos.Libro;
import com.atrium.master.pojos.Prestamo;
import com.atrium.master.pojos.Usuario;
import com.atrium.master.services.helper.LibroJDBCTest;
import com.atrium.master.services.helper.PrestamoJDBCTest;
import com.atrium.master.services.helper.UsuarioJDBCTest;
import com.atrium.master.services.helper.PojosJDBCTest.LibroPojoJDBCTest;
import com.atrium.master.services.helper.PojosJDBCTest.PrestamoPojoJDBCTest;
import com.atrium.master.services.helper.PojosJDBCTest.UsuarioPojoJDBCTest;

/**
 * @author Supercarlillos
 * 
 */

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PrestamosHibernateBOTest {

	@Before
	public void inicializar() throws ParseException {
		libroPojoJDBCTest.setAutor("AutorTest");
		libroPojoJDBCTest.setIsb("155541654");
		libroPojoJDBCTest.setSipnosis("El primer libro en los test");
		libroPojoJDBCTest.setTitulo("Titulo Test");

		usuarioPojoJDBCTest.setNumeroSocio(2l);
		usuarioPojoJDBCTest.setNombre("Antonio");
		usuarioPojoJDBCTest.setApellidos("Pojo Test");
		usuarioPojoJDBCTest.setTelefono(666666666);
		usuarioPojoJDBCTest.setDni("12345678Y");

		formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		fechaSalida = formatoDelTexto.parse("2011-06-01");
		fechaLimiteEntrega = formatoDelTexto.parse("2011-07-01");

		prestamoPojoJDBCTest.setFechaSalida(fechaSalida);
		prestamoPojoJDBCTest.setFechaLimiteEntrega(fechaLimiteEntrega);

	}

	@Inject
	private UsuarioJDBCTest gestorUsuariosJDBC;
	@Inject
	private LibroJDBCTest gestorLibrosJDBC;

	private Date fechaSalida, fechaLimiteEntrega;
	private SimpleDateFormat formatoDelTexto;

	@Inject
	private Prestamo prestamoTest;
	@Inject
	private PrestamosHibernateBO gestorPrestamosHibernate;
	@Inject
	private PrestamoJDBCTest gestorPrestamosJDBC;
	@Inject
	private PrestamoPojoJDBCTest prestamoPojoJDBCTest;
	@Inject
	private Libro libroTest;
	@Inject
	private LibroPojoJDBCTest libroPojoJDBCTest;
	@Inject
	private UsuarioPojoJDBCTest usuarioPojoJDBCTest;
	@Inject
	private Usuario usuarioTest;

	@Test
	public void insertar_prestamo() throws ParseException {

		Long idLibro = gestorLibrosJDBC.save(libroPojoJDBCTest, "Libros");
		Long idUsuario = gestorUsuariosJDBC.save(usuarioPojoJDBCTest,
				"Usuarios");

		libroTest = new Libro(idLibro, "155541654", "Titulo Test", "AutorTest",
				"El primer libro en los test");
		usuarioTest.setId(idUsuario);
		usuarioTest.setNumeroSocio(2l);
		usuarioTest.setNombre("Antonio");
		usuarioTest.setApellidos("Pojo Test");
		usuarioTest.setTelefono(666666666);
		usuarioTest.setDni("12345678Y");

		prestamoTest = new Prestamo(fechaSalida, fechaLimiteEntrega, null);
		prestamoTest.setLibro(libroTest);
		prestamoTest.setUsuario(usuarioTest);

		Long idPrestamo = gestorPrestamosHibernate.createPrestamo(prestamoTest);
		assertNotNull(idPrestamo);

		gestorLibrosJDBC.deleteTable("listaprestamo");
		gestorLibrosJDBC.deleteById(idLibro, "Libros");
		gestorUsuariosJDBC.deleteById(idUsuario, "Usuarios");
		gestorPrestamosJDBC.deleteById(idPrestamo, "Prestamos");
	}

	@Test
	public void modificar_los_datos_de_un_Prestamo() throws ParseException {
		Long id = gestorPrestamosJDBC.save(prestamoPojoJDBCTest, "Prestamos");
		Date fechaEntrega = this.formatoDelTexto.parse("2011-06-15");

		prestamoTest = new Prestamo(id, this.fechaSalida,
				this.fechaLimiteEntrega, fechaEntrega);
		gestorPrestamosHibernate.update(prestamoTest);

		PrestamoPojoJDBCTest prestamoPojoJDBCAux = gestorPrestamosJDBC.getById(
				id, "Prestamos");

		assertTrue(
				"El valor de la fechaDeEtrega no es correto",
				prestamoPojoJDBCAux.getFechaEntrega().compareTo(fechaEntrega) == 0);

		gestorPrestamosJDBC.deleteById(id, "Prestamos");

	}

	@Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
	public void borrar_prestamo() {

		Long id = gestorPrestamosJDBC.save(prestamoPojoJDBCTest, "Prestamos");

		prestamoTest = new Prestamo(id, this.fechaSalida,this.fechaLimiteEntrega, null);
		gestorPrestamosHibernate.delete(prestamoTest);

		gestorPrestamosJDBC.getById(id, "Prestamos");

	}

}
