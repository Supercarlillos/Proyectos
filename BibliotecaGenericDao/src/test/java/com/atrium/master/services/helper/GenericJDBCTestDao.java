package com.atrium.master.services.helper;

import java.io.Serializable;

public interface GenericJDBCTestDao <T extends Serializable,ID extends Serializable>{

	public ID save(T object);
	
/*	public ID create(T object);
	public ID update(T object);
	public ID delete(T object);*/
}
