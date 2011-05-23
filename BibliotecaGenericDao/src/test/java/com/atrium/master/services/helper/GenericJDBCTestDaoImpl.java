package com.atrium.master.services.helper;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.azeckoski.reflectutils.ReflectUtils;
import org.azeckoski.reflectutils.ClassFields.FieldsFilter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class GenericJDBCTestDaoImpl<T extends Serializable, ID extends Serializable>
		extends JdbcDaoSupport implements GenericJDBCTestDao<T, ID> {

	/*
	 * private NamesRecord getNamesRecord(Class<?> type) { NamesRecord nr =
	 * namesRecordsCache.get(type); if (nr == null) { // get a names record from
	 * the data mapper DataMapper dm = getDataMapper(type); nr =
	 * dm.getPropertyToColumnNamesMapping(); if (nr != null) {
	 * nr.setIdentifierProperty(findIdProperty(type)); if
	 * (nr.getForeignKeyPropertyNames().isEmpty()) { // check for foreign keys
	 * and add them (only complete fields // though) Map<String, Class<?>> types
	 * = ReflectUtils.getInstance() .getFieldTypes(type, FieldsFilter.COMPLETE);
	 * for (Entry<String, Class<?>> entry : types.entrySet()) { // special
	 * handling for foreign keys identified by // persistent types inside this
	 * object String property = entry.getKey(); Class<?> pType =
	 * entry.getValue(); if (getPersistentClasses().contains(pType)) { // this
	 * is another persistent object so this must be // a foreign key String pId
	 * = findIdProperty(pType); String fkProp = property + "." + pId; String
	 * column = nr.getColumnForProperty(property); if (column != null) {
	 * nr.setForeignKeyMapping(fkProp, column); } } } }
	 * namesRecordsCache.put(type, nr); } } if (nr == null) { boolean
	 * usePropertyNamesForColumns = false; DataMapper dm = getDataMapper(type);
	 * 
	 * ReflectUtils reflectUtils = ReflectUtils.getInstance(); // try to get the
	 * mapping from the class using annotations ClassFields<?> classFields =
	 * reflectUtils.analyzeClass(type); if
	 * (classFields.getClassAnnotations().contains(
	 * PersistentColumnMappingPolicy.class)) { for (Annotation classAnnote :
	 * classFields.getClassAnnotations()) { if
	 * (PersistentColumnMappingPolicy.class.equals(classAnnote
	 * .annotationType())) { MappingPolicy mp = ((PersistentColumnMappingPolicy)
	 * classAnnote) .policy(); if (MappingPolicy.FIELD_NAMES.equals(mp)) {
	 * usePropertyNamesForColumns = true; } else if
	 * (MappingPolicy.UPPER_UNDERSCORES.equals(mp)) { usePropertyNamesForColumns
	 * = false; } } if (dm instanceof SimpleDataMapper) { // override the
	 * setting ((SimpleDataMapper) dm)
	 * .setUsePropertyNamesForColumns(usePropertyNamesForColumns); } } } else {
	 * // no annotation so get the setting from the data mapper if (dm
	 * instanceof SimpleDataMapper) { usePropertyNamesForColumns =
	 * ((SimpleDataMapper) dm) .isUsePropertyNamesForColumns(); } }
	 * 
	 * // create a names mapping using reflection nr = new NamesRecord();
	 * Map<String, Class<?>> types = reflectUtils.getFieldTypes(type,
	 * FieldsFilter.COMPLETE); for (Entry<String, Class<?>> entry :
	 * types.entrySet()) { String property = entry.getKey(); Class<?> pType =
	 * entry.getValue(); String column = property; // check for transient
	 * annotation try { Annotation annotation = classFields.getFieldAnnotation(
	 * PersistentTransient.class, property); if (annotation != null) { // skip
	 * this one continue; } } catch (FieldnameNotFoundException e) { // nothing
	 * to do } if (!usePropertyNamesForColumns) { column =
	 * BasicTranslator.makeDBNameFromCamelCase(property); } // check for
	 * annotation override to column name try { PersistentColumnName annotation
	 * = (PersistentColumnName) classFields
	 * .getFieldAnnotation(PersistentColumnName.class, property); if (annotation
	 * != null) { column = annotation.value(); } } catch
	 * (FieldnameNotFoundException e) { // nothing to do }
	 * nr.setNameMapping(property, column); // special handling for foreign keys
	 * identified by persistent // types inside this object if
	 * (getPersistentClasses().contains(pType)) { // this is another persistent
	 * object so this must be a // foreign key String pId =
	 * findIdProperty(pType); String fkProp = property + "." + pId;
	 * nr.setForeignKeyMapping(fkProp, column); } } // add in the special id
	 * marker and make sure the id is set right
	 * nr.setIdentifierProperty(findIdProperty(type));
	 * namesRecordsCache.put(type, nr); if (dm instanceof SimpleDataMapper) { //
	 * put this NamesRecord back into the DataMapper ((SimpleDataMapper)
	 * dm).setNamesRecord(nr); } } return nr; }
	 */
	public ID save(T entity) {
		// NamesRecord nr = getNamesRecord(type);
		Class<?> type = (Class<?>) findClass(entity);
		List<String> keys = new ArrayList<String>();
		Map<String, Class<?>> types = ReflectUtils.getInstance().getFieldTypes(
				type);
		Map<String, Object> objectValues = ReflectUtils.getInstance().getObjectValues(entity, FieldsFilter.READABLE, false);
		Iterator it = objectValues.entrySet().iterator(); 
		while (it.hasNext()) { 
			Map.Entry e = (Map.Entry)it.next(); 
			System.out.println(e.getKey() + " " + e.getValue()); 
		} 
		StringBuilder update = new StringBuilder();
		StringBuilder columns = new StringBuilder();
		StringBuilder values = new StringBuilder();
		int counter = 0;
		for (String key : types.keySet()) {
			if (key.equals("id")) {
				continue;
			}
			if (counter > 0) {
				update.append(',');
				// insert
				columns.append(',');
				values.append(',');
			}
			// String column = nr.getColumnForProperty(key);
			String column = key;
			update.append(column);
			update.append("=?");
			keys.add(column);
			// insert
			columns.append(column);
			values.append('?');
			counter++;
		}
		String sql = "INSERT INTO LIBROS ("+columns+") VALUES ("+objectValues.toString()+")";
		getJdbcTemplate().update(sql);
		
		// make and do inserts
		/*int changes = 0;
		String sql = makeSQL(getInsertTemplate(type),
					getTableNameFromClass(type), StatementMapper.COLUMNS,
					columns.toString(), StatementMapper.VALUES,
					values.toString());
			if (showSQL) {
				logInfo("SQL=" + sql + ":\n BatchCreate=" + keys);
			}
			getJdbcTemplate().update(sql,
					new MyPSS(keys, newObjects, nr));
		
		// make and do updates
		if (existingObjects.size() > 0) {
			keys.add(nr.getColumnForProperty(idProp));
			String sql = makeSQL(getUpdateTemplate(type),
					getTableNameFromClass(type), StatementMapper.UPDATE,
					update.toString(), StatementMapper.WHERE, "where "
							+ getIdColumn(type) + " = ?");
			// do the batch update
			if (showSQL) {
				logInfo("SQL=" + sql + ":\n BatchUpdate=" + keys);
			}
			getSpringJdbcTemplate().batchUpdate(sql,
					new MyPSS(keys, existingObjects, nr));
		}*/
		return null;}

	private Class<?> findClass(Object entity) {
		if (entity == null) {
			throw new IllegalArgumentException(
					"Cannot find class type of null entity object");
		}
		Class<?> type = entity.getClass();
		return type;
	}

}
