package com.atrium.master.services.helper;

import java.io.Serializable;

public interface GenericJDBCTestDao<T extends Serializable, ID extends Serializable> {

	public ID save(T object, String TName);

	public int delete(ID object, String TName);

	public T getById(ID object, String TName);

	/*
	 * public ID update(T object);
	 */
}
