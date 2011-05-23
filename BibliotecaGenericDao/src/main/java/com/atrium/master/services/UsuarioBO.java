package com.atrium.master.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.atrium.master.dao.UsuarioDao;

@Component
public class UsuarioBO {

	@Inject
	private UsuarioDao gestorUsuariosDao;

	/*public List<Usuario> obtenerListadoUsuarios() {
		return gestorUsuariosDao.obtenerListadoUsuarios();
	}

	public Usuario agregarUsuario(Usuario usuario) {
		return gestorUsuariosDao.agregarUsuario(usuario);
	}

	public Usuario modificarDatosUsuario(Usuario usuario) {
		return gestorUsuariosDao.modificarDatosUsuario(usuario);
	}

	public int borrarUsuario(Long numsocio) {
		return gestorUsuariosDao.borrarUsuario(numsocio);
	}

	public Usuario obtenerUsuarioPorNumeroSocio(long id) {
		return gestorUsuariosDao.obtenerUsuarioPorNumeroSocio(id);
	}
*/
}
