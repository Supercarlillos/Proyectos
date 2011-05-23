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
import org.springframework.stereotype.Repository;

import com.atrium.master.dao.LibrosDao;
import com.atrium.master.pojos.Libro;

@Repository
public class LibrosDaoImpl extends GenericHibernateDaoImpl<Libro, Long> implements LibrosDao {

	public LibrosDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Comentamos Clases referentes al accesso via jdbc
	/*
	 * public Libro obtenerLibroPorId(final Long id) { final String SELECT_SQL =
	 * "select * from libro where identificador=?";
	 * 
	 * return getJdbcTemplate().queryForObject(SELECT_SQL, new
	 * RowMapper<Libro>() { public Libro mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { return new Libro(rs.getLong("identificador"), rs
	 * .getString("isbn"), rs.getString("titulo"), rs .getString("autor"),
	 * rs.getString("sipnosis")); } }, new Object[] { id }); }
	 * 
	 * public List<Libro> obtenerListadoLibrosDisponibles() { final String
	 * SELECT_SQL = "select * from libro";
	 * 
	 * final List<Libro> listado = new LinkedList<Libro>();
	 * 
	 * getJdbcTemplate().query(SELECT_SQL, new RowCallbackHandler() { public
	 * void processRow(ResultSet rs) throws SQLException { Libro libro = new
	 * Libro(rs.getLong("identificador"), rs .getString("isbn"),
	 * rs.getString("titulo"), rs .getString("autor"),
	 * rs.getString("sipnosis")); listado.add(libro); } }); return listado; }
	 * 
	 * public Libro agregarLibroNuevo(final Libro libroNuevo) {
	 * 
	 * final String INSERT_SQL =
	 * "INSERT INTO libro (isbn,titulo,autor,sipnosis) values(?,?,?,?)";
	 * KeyHolder keyHolder = new GeneratedKeyHolder();
	 * getJdbcTemplate().update(new PreparedStatementCreator() { public
	 * PreparedStatement createPreparedStatement( Connection connection) throws
	 * SQLException { PreparedStatement ps =
	 * connection.prepareStatement(INSERT_SQL, new String[] { "identificador"
	 * }); ps.setString(1, libroNuevo.getIsb()); ps.setString(2,
	 * libroNuevo.getTitulo()); ps.setString(3, libroNuevo.getAutor());
	 * ps.setString(4, libroNuevo.getSipnosis()); return ps; } }, keyHolder);
	 * libroNuevo.setIdentificador((Long) keyHolder.getKey()); return
	 * libroNuevo; }
	 * 
	 * public Libro modificarDatosLibro(final Libro libroNuevo) { final String
	 * UPDATE_SQL =
	 * "update libro set isbn=?,titulo=?,autor=?,sipnosis=? where identificador=?"
	 * ; KeyHolder keyHolder = new GeneratedKeyHolder();
	 * getJdbcTemplate().update(new PreparedStatementCreator() { public
	 * PreparedStatement createPreparedStatement( Connection connection) throws
	 * SQLException { PreparedStatement ps =
	 * connection.prepareStatement(UPDATE_SQL, new String[] { "identificador"
	 * }); ps.setString(1, libroNuevo.getIsb()); ps.setString(2,
	 * libroNuevo.getTitulo()); ps.setString(3, libroNuevo.getAutor());
	 * ps.setString(4, libroNuevo.getSipnosis()); ps.setLong(5,
	 * libroNuevo.getIdentificador()); return ps; } }, keyHolder); return
	 * libroNuevo; }
	 * 
	 * public int borrarLibroPorId(long id) {
	 * 
	 * final String DELETE_SQL = "delete from libro where identificador=?";
	 * 
	 * return getJdbcTemplate().update(DELETE_SQL,new Object[] { id });
	 * 
	 * }
	 */
}
