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

import com.atrium.master.pojos.Usuario;
import com.atrium.master.services.helper.UsuarioJDBCTest;
import com.atrium.master.services.helper.PojosJDBCTest.UsuarioPojoJDBCTest;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuariosHibernateBOTest {

	@Before
	public void inicializar() {
		usuarioPojoJDBCTest.setNumeroSocio(2l);
		usuarioPojoJDBCTest.setNombre("Antonio");
		usuarioPojoJDBCTest.setApellidos("Pojo Test");
		usuarioPojoJDBCTest.setTelefono(666666666);
		usuarioPojoJDBCTest.setDni("12345678Y");

	}

	@Inject
	private Usuario usuarioTest;
	@Inject
	private UsuariosHibernateBO gestorUsuariosHibernate;
	@Inject
	private UsuarioJDBCTest gestorUsuariosJDBC;
	@Inject
	private UsuarioPojoJDBCTest usuarioPojoJDBCTest;

	@Test
	public void insertar_usuario() {
		usuarioTest = new Usuario(1l, "1111111H", "Carlos", "Gamez Fuentes",
				699699699);

		Long identificador = gestorUsuariosHibernate.createUsuario(usuarioTest);
		assertNotNull(identificador);

		gestorUsuariosJDBC.deleteById(identificador, "Usuarios");

	}

	@Test
	public void buscar_Usuario_por_Id() {
		Long id = gestorUsuariosJDBC.save(usuarioPojoJDBCTest, "Usuarios");

		usuarioTest = gestorUsuariosHibernate.findUsuarioById(id);

		assertNotNull(usuarioTest);
		assertEquals("El nombre no es correcto", "Antonio",
				usuarioTest.getNombre());

		gestorUsuariosJDBC.deleteById(id, "Usuarios");

	}

	@Test
	public void obtener_todos_libros_disponibles() {
		Long id = gestorUsuariosJDBC.save(usuarioPojoJDBCTest, "Usuarios");

		List<Usuario> listadoUsuariosDisponibles = new LinkedList<Usuario>();
		listadoUsuariosDisponibles = gestorUsuariosHibernate.listAll();

		assertNotNull(listadoUsuariosDisponibles);
		assertTrue(listadoUsuariosDisponibles.size() > 0);
		assertTrue(listadoUsuariosDisponibles.size() == 1);

		gestorUsuariosJDBC.deleteById(id, "Usuarios");
	}

	@Test
	public void modificar_los_datos_de_un_Usuario() {
		Long id = gestorUsuariosJDBC.save(usuarioPojoJDBCTest, "Usuarios");

		usuarioTest = new Usuario(id, 2l, "12345678Y", "Pepito", "Palotes",
				666666666);
		gestorUsuariosHibernate.update(usuarioTest);

		UsuarioPojoJDBCTest usuarioPojoJDBCAux = gestorUsuariosJDBC.getById(id,
				"Usuarios");

		assertEquals("El valor del Nombre no es correto", "Pepito",
				usuarioPojoJDBCAux.getNombre());
		assertEquals("El valor del Apellido no es correto", "Palotes",
				usuarioPojoJDBCAux.getApellidos());

		gestorUsuariosJDBC.deleteById(id, "Usuarios");

	}

	@Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
	public void borrar_libro() {

		Long id = gestorUsuariosJDBC.save(usuarioPojoJDBCTest, "Usuarios");

		usuarioTest = new Usuario(id, 2l, "12345678Y", "Antonio", "Pojo Test",
				666666666);
		gestorUsuariosHibernate.delete(usuarioTest);

		gestorUsuariosJDBC.getById(id, "Usuarios");

	}

}
