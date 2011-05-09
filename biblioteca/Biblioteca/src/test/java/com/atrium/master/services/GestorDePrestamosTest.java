package com.atrium.master.services;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.atrium.master.modelo.Prestamo;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class GestorDePrestamosTest {

	@Before
	public void inicializar() {
		historicoPrestamo = new LinkedList<Prestamo>();
	}

	private List<Prestamo> historicoPrestamo;

	@Inject
	private GestorDePrestamosBO gestorDePrestamos;

	@Inject
	private Prestamo prestamoDummy;

	@Test
	public void consulta_historico_prestamos_por_usuario() {
		// Arrange
		// Act
		Long numSocio = 2l;

		historicoPrestamo = gestorDePrestamos
				.consultaHistoricoPrestamosPorNumSocio(numSocio);
		// Assert
		System.out.println(historicoPrestamo);
		assertNotNull(historicoPrestamo);
		assertEquals(
				"El número de prestamos no es correcto para el usuario con numero de socio: "
						+ numSocio, historicoPrestamo.size(), 1);

	}

	@Test
	public void consulta_historico_prestamos_por_libro() {
		// Arrange
		// Act
		Long identificador = 3l;
		historicoPrestamo = gestorDePrestamos
				.consultaHistoricoPrestamosPorIdentificadorLibro(identificador);
		// Assert
		System.out.println(historicoPrestamo);
		assertNotNull(historicoPrestamo);
		assertEquals(
				"El número de prestamos no es correcto para el libro con identificador: "
						+ identificador, historicoPrestamo.size(), 1);

	}

	@Test
	public void dar_de_alta_prestamo_libro() {
		// Arrange
		Long numSocio = 2l;
		Long identificador = 3l;
		// Act
		Date utilDate = new Date(); // fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		// Assert

		assertNotNull(gestorDePrestamos.aniadirPrestamo(identificador,
				numSocio, sqlDate));

	}

	@Test
	@Ignore
	public void actualizar_fecha_devolucion_libro() {
		// Arrange

		// Act
		// prestamoDummy.setIdentificador(1);
		// prestamoDummy.setNumeroSocio(2);

		// Assert
		assertTrue(gestorDePrestamos.actualizarFechaDevolucion(prestamoDummy));
	}

}
