package com.ats.formacion.hibernate.relaciones;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Direccion_B {
	Set<Persona> personas=new HashSet<Persona>();
	int id;
	
	String modelo;
	
	public Direccion_B() {
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

	public Direccion_B(String modelo) {
		super();
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}



	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

}
