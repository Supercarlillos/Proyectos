package com.atrium.master.pojos;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long numeroSocio;
	private String dni;
	private String nombre;
	private String apellidos;
	private Integer telefono;

	private Set<Prestamo> listaPrestamo;

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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setListaPrestamo(Set<Prestamo> listaPrestamo) {
		this.listaPrestamo = listaPrestamo;
	}

	public Set<Prestamo> getListaPrestamo() {
		return listaPrestamo;
	}

	public void addPrestamo(Prestamo prestamo) {
		if (listaPrestamo == null)
			listaPrestamo = new LinkedHashSet<Prestamo>();
		getListaPrestamo().add(prestamo);
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
