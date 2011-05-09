package com.ats.formacion.hibernate.daogenerico.modelo;

import java.io.Serializable;

public abstract class Entity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -264877372835432198L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
