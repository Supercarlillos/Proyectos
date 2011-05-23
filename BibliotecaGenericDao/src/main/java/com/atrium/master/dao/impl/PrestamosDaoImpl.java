package com.atrium.master.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.atrium.master.dao.PrestamosDao;

@Repository
public class PrestamosDaoImpl implements PrestamosDao {

	/*public boolean aniadirPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}*/

	/*public boolean actualizarFechaDevolucion(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Prestamo> consultaHistoricoPrestamosPorNumSocio(long numSocio) {
		final String SELECT_SQL = "select * from prestamo where numsocio=?";

		final List<Prestamo> prestamos = new LinkedList<Prestamo>();

		getJdbcTemplate().query(SELECT_SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Prestamo prestamo = new Prestamo(rs.getLong("identificador"),
						rs.getLong("numsocio"), rs.getDate("fechaSalida"), rs
								.getDate("fechaLimiteEntrega"), rs
								.getDate("fechaEntrega"));
				prestamos.add(prestamo);
			}
		}, new Object[] { numSocio });
		return prestamos;
	}

	public List<Prestamo> consultaHistoricoPrestamosPorIdentificadorLibro(
			Long identificador) {
		final String SELECT_SQL = "select * from prestamo where identificador=?";

		final List<Prestamo> prestamos = new LinkedList<Prestamo>();

		getJdbcTemplate().query(SELECT_SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Prestamo prestamo = new Prestamo(rs.getLong("identificador"),
						rs.getLong("numsocio"), rs.getDate("fechaSalida"), rs
								.getDate("fechaLimiteEntrega"), rs
								.getDate("fechaEntrega"));
				prestamos.add(prestamo);
			}
		}, new Object[] { identificador });
		return prestamos;
	}

	public int aniadirPrestamo(final Long identificadorLibro,
			final Long numSocio, final Date diaAlta) {

		final String INSERT_SQL = "INSERT INTO prestamo (identificador,numsocio,fechaSalida,fechaLimiteEntrega,fechaEntrega) values(?,?,?,?,null)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		return getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
						new String[] { "identificador", "numsocio",
								"fechaSalida", "fechaLimiteEntrega",
								"fechaEntrega" });
				ps.setLong(1, identificadorLibro);
				ps.setLong(2, numSocio);
				ps.setDate(3, diaAlta);
				ps.setDate(4, diaAlta);
				return ps;
			}
		}, keyHolder);
		// libroNuevo.setIdentificador((Long) keyHolder.getKey());
		// return libroNuevo;

	}*/

}
