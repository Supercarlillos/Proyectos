package com.atrium.master.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable,ID extends Serializable> {
	public ID insert (T element);
	public T retrieve(ID primaryKey);
	public List<T> findAll();
	public void update(T element);
	public void delete(T element);

}
