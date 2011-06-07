package com.atrium.master.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.atrium.master.dao.UsuarioDao;
import com.atrium.master.pojos.Usuario;

@Component
public class UsuariosHibernateBO {

	@Inject
	private UsuarioDao gestorUsuariosDao;

	public Long createUsuario(Usuario usuario) {
		return gestorUsuariosDao.insert(usuario);
	}

	public Usuario findUsuarioById(Long id) {
		return gestorUsuariosDao.retrieve(id);
	}

	public List<Usuario> listAll() {
		return gestorUsuariosDao.findAll();
	}

	public void update(Usuario usuario) {
		gestorUsuariosDao.update(usuario);

	}

	public void delete(Usuario usuario) {
		gestorUsuariosDao.delete(usuario);

	}

}
