package com.ats.formacion.hibernate.daogenerico;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, ID extends Serializable> {
	public ID create(T element);
	public T retrieve(ID primaryKey);
	public void update(T element);
	public void delete(T element);
	public List<T> findAll();

}
