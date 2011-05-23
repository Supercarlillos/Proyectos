package com.atrium.master.pojos;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String isb;
	private String titulo;
	private String autor;
	private String sipnosis;
	private Prestamo prestamo;

	public Libro() {
	}

	public Libro(String isb, String titulo, String autor, String sipnosis) {
		this.isb = isb;
		this.titulo = titulo;
		this.autor = autor;
		this.sipnosis = sipnosis;
	}

	public String getIsb() {
		return isb;
	}

	public void setIsb(String isb) {
		this.isb = isb;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSipnosis() {
		return sipnosis;
	}

	public void setSipnosis(String sipnosis) {
		this.sipnosis = sipnosis;
	}

	public void setid(Long identificador) {
		id = identificador;
	}

	public Long getid() {
		return id;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Prestamo getPrestamo() {
		return prestamo;
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
