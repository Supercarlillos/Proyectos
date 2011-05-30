package com.atrium.master.services.helper;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.atrium.master.services.helper.utils.ReflexionUtils;

public abstract class GenericJDBCTestDaoImpl<T extends Serializable, ID extends Serializable>
		extends JdbcDaoSupport implements GenericJDBCTestDao<T, ID> {

	private Class<?> objeto;
	private Map<String, Class<?>> propiedadesDelObjeto;
	private Map<String, Object> valoresPropiedadesObjeto;
	private StringBuffer nombreColumnas = new StringBuffer();
	private StringBuffer values = new StringBuffer();
	private String INSERT_SQL;
	private String nombreTabla;
	
	@Inject
	private ReflexionUtils reflexionUtils;

	@SuppressWarnings("unchecked")
	public GenericJDBCTestDaoImpl() {
		this.objeto = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getById(ID identificador, String TName) {
		this.limpiarVariables();
		String sql = "SELECT * FROM " + TName + " WHERE id = ?";
		return (T) getJdbcTemplate().queryForObject(sql,
				new Object[] { identificador },
				new BeanPropertyRowMapper(objeto));

	}

	public int delete(ID identificador, String TName) {

		String DELETE_SQL = "DELETE FROM " + TName + " WHERE id=?";
		return getJdbcTemplate().update(DELETE_SQL,
				new Object[] { identificador });
	}

	@SuppressWarnings("unchecked")
	public ID save(T entity, String TName) {
		this.limpiarVariables();
		nombreTabla = TName;
		propiedadesDelObjeto = reflexionUtils.getTypesFields(objeto);
		valoresPropiedadesObjeto = reflexionUtils.getObjectValues(entity);
		this.obtenerInsertSQL();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(this.obtenerPreparedStatementCreatorInsert(),
				keyHolder);
		return (ID) keyHolder.getKey();
	}

	private PreparedStatementCreator obtenerPreparedStatementCreatorInsert() {
		return new PreparedStatementCreator() {
			@SuppressWarnings("rawtypes")
			private Iterator interadorValoresClase;
			private PreparedStatement preparedStatement;
			@SuppressWarnings("rawtypes")
			private Map.Entry parVariableValor;

			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				preparedStatement = connection.prepareStatement(INSERT_SQL,
						new String[] { "id" });
				introducirValoresInsert();
				return preparedStatement;
			}

			@SuppressWarnings("rawtypes")
			private void introducirValoresInsert() throws SQLException {
				int posicion = 1;
				interadorValoresClase = valoresPropiedadesObjeto.entrySet()
						.iterator();
				while (interadorValoresClase.hasNext()) {
					parVariableValor = (Map.Entry) interadorValoresClase.next();
					if (isparVariableValorString())
						preparedStatement.setString(posicion,
								(String) parVariableValor.getValue());
					else if (isparVariableValorInteger())
						preparedStatement.setInt(posicion,
								(Integer) parVariableValor.getValue());
					posicion++;
				}
			}

			private boolean isparVariableValorInteger() {
				return parVariableValor.getValue() instanceof Integer;
			}

			private boolean isparVariableValorString() {
				return parVariableValor.getValue() instanceof String;
			}
		};
	}

	private void obtenerInsertSQL() {
		int counter = 0;
		for (String key : propiedadesDelObjeto.keySet()) {
			if (key.equals("id")) {
				continue;
			}
			if (counter > 0) {
				// insert
				nombreColumnas.append(',');
				values.append(',');
			}
			nombreColumnas.append(key);
			values.append('?');
			counter++;
		}
		INSERT_SQL = "INSERT INTO " + nombreTabla + " (" + nombreColumnas
				+ ") VALUES (" + values + ")";
	}

	private void limpiarVariables() {
		if (propiedadesDelObjeto != null)
			propiedadesDelObjeto.clear();

		if (valoresPropiedadesObjeto != null)
			valoresPropiedadesObjeto.clear();

		nombreColumnas.delete(0, nombreColumnas.length());
		values.delete(0, values.length());
	}
}
