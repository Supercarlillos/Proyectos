package com.atrium.master.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.MessageSource;


import com.atrium.master.dao.GestorDeUsuarioDao;
import com.atrium.master.excepciones.ErrorException;
import com.atrium.master.modelo.Usuario;

public class GestorDeUsuariosDaoImplDummy implements GestorDeUsuarioDao {

	private List<Usuario> listadoUsuariosDummy = new ArrayList<Usuario>();

	@Inject
	private Usuario usuario1, usuario2, usuario3, usuarioNuevo;

	@Inject
	private MessageSource fuenteDeMensajes;

	private Locale locale = new Locale("es");

	public GestorDeUsuariosDaoImplDummy() {
		// TODO Auto-generated constructor stub
	}

	public List<Usuario> obtenerListadoUsuarios() {
		return listadoUsuariosDummy;
	}

	public Usuario agregarUsuario(Usuario usuario) {
		usuarioNuevo = usuario;
		validarCamposUsuarioNuevo();
		usuarioNuevo.setNumeroSocio((long) (listadoUsuariosDummy.size() + 1));
		listadoUsuariosDummy.add(usuarioNuevo);
		return usuarioNuevo;
	}

	public Usuario modificarDatosUsuario(Usuario usuario) {
		usuarioNuevo = usuario;
		validarCamposUsuarioNuevo();
		for (Usuario aux : listadoUsuariosDummy) {
			if (coincidenNumeroSocio(usuarioNuevo, aux)) {
				actualizarDatosUsuario(aux);
				return usuarioNuevo;
			}
		}
		lanzarExceptionUsuarioNoExiste();
		return usuarioNuevo;
	}

	public int borrarUsuario(Usuario usuario) {
		usuarioNuevo = usuario;
		for (Usuario aux : listadoUsuariosDummy) {
			if (usuarioNuevo.equals(aux)) {
				listadoUsuariosDummy.remove(aux);
				return 1;
			}
		}
		lanzarExceptionUsuarioNoExiste();
		return 1;
	}

	private void lanzarExceptionUsuarioNoExiste() {
		String str[] = { usuarioNuevo.toString() };
		String mensaje = fuenteDeMensajes.getMessage("ErrorNoExisteUsuario",
				str, locale);
		throw new ErrorException(mensaje);
	}

	private boolean coincidenNumeroSocio(Usuario usuario, Usuario aux) {
		return aux.getNumeroSocio() == usuario.getNumeroSocio();
	}

	private void actualizarDatosUsuario(Usuario aux) {
		listadoUsuariosDummy.remove(aux);
		listadoUsuariosDummy.add(usuarioNuevo);
	}

	private void validarCamposUsuarioNuevo() {
		if (!esApellidoValido()) {
			lanzarExceptionValidacion("Apellido");
		}
		if (!esDniValido()) {
			lanzarExceptionValidacion("DNI");
		}
		if (!esNombreValido()) {
			lanzarExceptionValidacion("Nombre");
		}
		if (!esTelefonoValido()) {
			lanzarExceptionValidacion("Telefono");
		}
	}

	private void lanzarExceptionValidacion(String causa) {
		String str[] = { usuarioNuevo.toString(), "falta Campo" + causa };
		String mensaje = fuenteDeMensajes.getMessage("ErrorValidacionUsuario",
				str, locale);
		throw new ErrorException(mensaje);
	}

	private boolean esApellidoValido() {
		return ((usuarioNuevo.getApellidos() != "") && (usuarioNuevo
				.getApellidos() != null));
	}

	private boolean esDniValido() {
		return ((usuarioNuevo.getDni() != "") && (usuarioNuevo.getDni() != null));
	}

	private boolean esNombreValido() {
		return ((usuarioNuevo.getNombre() != "") && (usuarioNuevo.getNombre() != null));
	}

	private boolean esTelefonoValido() {
		return (usuarioNuevo.getTelefono() != null);
	}
	
	@PostConstruct
	@SuppressWarnings({ "unused" })
	private void inicioVariablesDummies() {

		usuario1.setNumeroSocio(1l);
		usuario1.setDni("11111111H");
		usuario1.setNombre("Gerard");
		usuario1.setApellidos("Pique");
		usuario1.setTelefono(666666666);

		usuario2.setNumeroSocio(2l);
		usuario2.setDni("11111111E");
		usuario2.setNombre("Mourinho");
		usuario2.setApellidos("Pique");
		usuario2.setTelefono(999999999);

		usuario3.setNumeroSocio(3l);
		usuario3.setDni("11111111R");
		usuario3.setNombre("Iker");
		usuario3.setApellidos("Casillas");
		usuario3.setTelefono(111111111);

		listadoUsuariosDummy.add(usuario1);
		listadoUsuariosDummy.add(usuario2);
		listadoUsuariosDummy.add(usuario3);

	}

	public Usuario obtenerUsuarioPorNumeroSocio(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int borrarUsuario(Long numSocio) {
		// TODO Auto-generated method stub
		return 0;
	}
}
