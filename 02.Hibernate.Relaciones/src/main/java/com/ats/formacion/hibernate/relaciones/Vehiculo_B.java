package com.ats.formacion.hibernate.relaciones;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Vehiculo_B {
	Persona p;
	int id;	
	String modelo;
	
	public Vehiculo_B() {
		// TODO Auto-generated constructor stub
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehiculo_B(String modelo) {
		super();
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Persona getP() {
		return p;
	}

	public void setP(Persona p) {
		this.p = p;
	}

}
