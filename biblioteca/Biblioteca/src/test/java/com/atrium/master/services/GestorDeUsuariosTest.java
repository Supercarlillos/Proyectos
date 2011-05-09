package com.atrium.master.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atrium.master.modelo.Usuario;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class GestorDeUsuariosTest {

	/*
	 * @Before public void inicializar() { usuarioDummy.setNumeroSocio(null);
	 * usuarioDummy.setDni(null); usuarioDummy.setNombre(null);
	 * usuarioDummy.setApellidos(null); usuarioDummy.setTelefono(null); }
	 */

	@Inject
	private GestorDeUsuarioBO gestorDeUsuarios;

	@Inject
	private Usuario usuarioDummy;

	@Test
	public void obtener_usuario_por_numero_de_socio() {
		// Arrange
		// Act
		usuarioDummy = gestorDeUsuarios.obtenerUsuarioPorNumeroSocio(1l);

		// Asserts
		System.out.println(usuarioDummy);
		assertNotNull(usuarioDummy);
	}

	@Test
	public void obtener_listado_de_Usuarios() {
		// Arrange

		// Act
		List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
		listadoUsuarios = gestorDeUsuarios.obtenerListadoUsuarios();

		// Asserts
		// Asserts
		System.out.println(listadoUsuarios);
		assertNotNull(listadoUsuarios);
		assertEquals(
				"El tamaño del vector de los libros disponibles no es válido: ",
				3, listadoUsuarios.size());
	}

	@Test
	public void aniadir_usuario_nuevo() {
		// Arrange

		// Act
		usuarioDummy.setDni("12345678T");
		usuarioDummy.setNombre("Antonio");
		usuarioDummy.setApellidos("Maachine");
		usuarioDummy.setTelefono(569856856);

		// Asserts
		assertTrue(gestorDeUsuarios.agregarUsuario(usuarioDummy)
				.getNumeroSocio() != null);
		List<Usuario> listadoUsuariosDisponibles = new ArrayList<Usuario>();
		listadoUsuariosDisponibles = gestorDeUsuarios.obtenerListadoUsuarios();
		assertEquals("No ha aumentado número de libros disponibles", 4,
				listadoUsuariosDisponibles.size());
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void agrega_libro_nuevo_faltando_algun_campo_devuelve_exception() {
		// Arrange
		usuarioDummy.setDni("12345678T");
		usuarioDummy.setApellidos("Maachine");
		usuarioDummy.setTelefono(569856856);

		// Act
		// Asserts
		//assertTrue(gestorDeUsuarios.agregarUsuario(usuarioDummy));
	}

	@Test
	public void modifica_datos_de_usuario() {
		// Arrange
		usuarioDummy.setNumeroSocio(1l);
		usuarioDummy.setDni("99999999T");
		usuarioDummy.setNombre("El tio");
		usuarioDummy.setApellidos("de la vara");
		usuarioDummy.setTelefono(569856856);

		// Act

		// Asserts
		assertNotNull(gestorDeUsuarios.modificarDatosUsuario(usuarioDummy));
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void modifica_datos_de_usario_falta_algun_dato() {
		// Arrange
		usuarioDummy.setNumeroSocio(1l);
		usuarioDummy.setDni("12345678T");
		usuarioDummy.setApellidos("de la vara");
		usuarioDummy.setTelefono(569856856);

		// Act
		// Asserts
		gestorDeUsuarios.modificarDatosUsuario(usuarioDummy);
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void modifica_datos_de_usuario_no_existe_libro() {
		// Arrange
		usuarioDummy.setNumeroSocio(10l);
		usuarioDummy.setDni("12345678T");
		usuarioDummy.setNombre("El tio");
		usuarioDummy.setApellidos("de la vara");
		usuarioDummy.setTelefono(569856856);

		// Act
		// Asserts
		gestorDeUsuarios.modificarDatosUsuario(usuarioDummy);
	}

	@Test
	public void borrado_usuario_por_numSocio() {
		// Arrange
		// Act

		// Asserts
		assertEquals("No se ha borrado el usuario con numScocio"+String.valueOf(4l),gestorDeUsuarios.borrarUsuario(4l),1);
	}

	@Test(expected = com.atrium.master.excepciones.ErrorException.class)
	@Ignore
	public void borrado_libro_no_existe_libro() {
		// Arrange
		usuarioDummy.setNumeroSocio(3l);
		usuarioDummy.setDni("11111111R");
		usuarioDummy.setNombre("Iker");
		usuarioDummy.setApellidos("Casillas");
		usuarioDummy.setTelefono(111111111);
		// Act

		// Asserts
		//gestorDeUsuarios.borrarUsuario(usuarioDummy);
	}

}
