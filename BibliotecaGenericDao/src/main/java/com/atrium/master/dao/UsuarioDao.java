package com.atrium.master.dao;

import org.springframework.stereotype.Repository;

import com.atrium.master.pojos.Usuario;

@Repository
public interface UsuarioDao extends GenericDao<Usuario, Long>{
}
