package com.atrium.master.services.helper.utils;

import java.util.Map;

public interface ReflexionUtils {

	public Map<String, Class<?>> getTypesFields(Class<?> type);

	public Map<String, Object> getObjectValues(Object type);

}
