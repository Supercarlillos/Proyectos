package com.atrium.master.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.atrium.master.dao.GestorDeUsuarioDao;
import com.atrium.master.modelo.Usuario;

public class GestorDeUsuariosDaoImpl extends JdbcDaoSupport implements
		GestorDeUsuarioDao {

	public Usuario obtenerUsuarioPorNumeroSocio(long id) {
		final String SELECT_SQL = "select * from usuario where numsocio=?";

		return getJdbcTemplate().queryForObject(SELECT_SQL,
				new RowMapper<Usuario>() {
					public Usuario mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return new Usuario(rs.getLong("numsocio"), rs
								.getString("dni"), rs.getString("nombre"), rs
								.getString("apellidos"), rs.getInt("telefono"));
					}
				}, new Object[] { id });
	}

	public List<Usuario> obtenerListadoUsuarios() {
		final String SELECT_SQL = "select * from usuario";

		final List<Usuario> listado = new LinkedList<Usuario>();

		getJdbcTemplate().query(SELECT_SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Usuario usuario = new Usuario(rs.getLong("numsocio"), rs
						.getString("dni"), rs.getString("nombre"), rs
						.getString("apellidos"), rs.getInt("telefono"));
				listado.add(usuario);
			}
		});
		return listado;
	}

	public Usuario agregarUsuario(final Usuario usuario) {
		final String INSERT_SQL = "INSERT INTO usuario (dni,nombre,apellidos,telefono) values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
						new String[] { "numsocio" });
				ps.setString(1, usuario.getDni());
				ps.setString(2, usuario.getNombre());
				ps.setString(3, usuario.getApellidos());
				ps.setInt(4, usuario.getTelefono());
				return ps;
			}
		}, keyHolder);
		usuario.setNumeroSocio((Long) keyHolder.getKey());
		return usuario;
	}

	public Usuario modificarDatosUsuario(final Usuario usuario) {
		final String UPDATE_SQL = "update usuario set dni=?,nombre=?,apellidos=?,telefono=? where numsocio=?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL,
						new String[] { "numsocio" });
				ps.setString(1, usuario.getDni());
				ps.setString(2, usuario.getNombre());
				ps.setString(3, usuario.getApellidos());
				ps.setInt(4, usuario.getTelefono());
				ps.setLong(5, usuario.getNumeroSocio());
				return ps;
			}
		}, keyHolder);
		return usuario;
	}

	public int borrarUsuario(Long numSocio) {
		final String DELETE_SQL = "delete from usuario where numsocio=?";
		return getJdbcTemplate().update(DELETE_SQL, new Object[] { numSocio });

	}

}
