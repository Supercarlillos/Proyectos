package com.atrium.master.pojos;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long numeroSocio;
	private String dni;
	private String nombre;
	private String apellidos;
	private Integer telefono;

	public Usuario(Long numeroSocio, String dni, String nombre,
			String apellidos, Integer telefono) {

		this.numeroSocio = numeroSocio;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	public Usuario() {
	}

	public Long getNumeroSocio() {
		return numeroSocio;
	}

	public void setNumeroSocio(Long numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
