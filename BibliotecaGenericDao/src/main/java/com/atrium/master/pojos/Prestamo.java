package com.atrium.master.pojos;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Prestamo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date fechaSalida;
	private Date fechaLimiteEntrega;
	private Date fechaEntrega;

	private Libro libro;
	private Usuario usuario;

	public Prestamo() {
	}

	public Prestamo(Date fechaSalida, Date fechaLimiteEntrega, Date fechaEntrega) {
		super();
		this.fechaSalida = fechaSalida;
		this.fechaLimiteEntrega = fechaLimiteEntrega;
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLimiteEntrega() {
		return fechaLimiteEntrega;
	}

	public void setFechaLimiteEntrega(Date fechaLimiteEntrega) {
		this.fechaLimiteEntrega = fechaLimiteEntrega;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
		libro.setPrestamo(this);
	}

	public Libro getLibro() {
		return libro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		usuario.addPrestamo(this);
	}

	public Usuario getUsuario() {
		return usuario;
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
