package com.atrium.master.dao;

import java.util.List;
import com.atrium.master.modelo.Usuario;


public interface GestorDeUsuarioDao {

	public List<Usuario> obtenerListadoUsuarios();

	public Usuario agregarUsuario(Usuario usuario);

	public Usuario modificarDatosUsuario(Usuario usuario);

	public int borrarUsuario(Long numSocio);

	public Usuario obtenerUsuarioPorNumeroSocio(long id);

}
