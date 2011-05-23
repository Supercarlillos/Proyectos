package com.atrium.master.dao;

import java.io.Serializable;

public interface GenericDao<T extends Serializable,ID extends Serializable> {
	public ID insert (T element);
	public T retrieve(ID primaryKey);
	/*public void update(T element);
	public void delete(T element);
	public List<T> findAll();*/

}
