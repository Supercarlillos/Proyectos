package com.atrium.master.dao.impl;

import org.springframework.stereotype.Repository;

import com.atrium.master.dao.UsuarioDao;
import com.atrium.master.pojos.Usuario;

@Repository
public class UsuariosDaoImpl extends GenericHibernateDaoImpl<Usuario, Long>
		implements UsuarioDao {
}
