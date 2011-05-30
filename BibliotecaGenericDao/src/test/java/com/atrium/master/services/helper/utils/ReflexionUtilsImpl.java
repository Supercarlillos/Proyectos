package com.atrium.master.services.helper.utils;

import java.util.Map;

import org.azeckoski.reflectutils.ReflectUtils;
import org.azeckoski.reflectutils.ClassFields.FieldsFilter;
import org.springframework.stereotype.Component;

@Component
public class ReflexionUtilsImpl implements ReflexionUtils {

	public Map<String, Class<?>> getTypesFields(Class<?> type) {
		return ReflectUtils.getInstance().getFieldTypes(type);
	}

	public Map<String, Object>getObjectValues(Object type) {
		return ReflectUtils.getInstance().getObjectValues(type,
				FieldsFilter.READABLE, false);
	}

}
