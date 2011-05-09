package com.atrium.master.modelo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Libro {

	private Long Identificador;
	private String Isb;
	private String Titulo;
	private String Autor;
	private String Sipnosis;

	public Libro() {
	}

	public Libro(Long identificador, String isb, String titulo,
			String autor, String sipnosis) {
		Identificador = identificador;
		Isb = isb;
		Titulo = titulo;
		Autor = autor;
		Sipnosis = sipnosis;
	}

	public String getIsb() {
		return Isb;
	}

	public void setIsb(String isb) {
		Isb = isb;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getSipnosis() {
		return Sipnosis;
	}

	public void setSipnosis(String sipnosis) {
		Sipnosis = sipnosis;
	}

	public void setIdentificador(Long identificador) {
		Identificador = identificador;
	}

	public Long getIdentificador() {
		return Identificador;
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
