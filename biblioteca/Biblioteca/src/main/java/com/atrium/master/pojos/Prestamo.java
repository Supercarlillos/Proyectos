package com.atrium.master.pojos;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Prestamo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long Identificador;
	private Long numSocio;
	private Date fechaSalida;
	private Date fechaLimiteEntrega;
	private Date fechaEntrega;
		
	
	public Long getIdentificador() {
		return Identificador;
	}
	
	public Prestamo() {
	}

	public Prestamo(Long identificador, Long numeroSocio,
			Date fechaSalida, Date fechaLimiteEntrega, Date fechaEntrega) {
		super();
		Identificador = identificador;
		this.numSocio = numeroSocio;
		this.fechaSalida = fechaSalida;
		this.fechaLimiteEntrega = fechaLimiteEntrega;
		this.fechaEntrega = fechaEntrega;
	}

	public Long getNumeroSocio() {
		return numSocio;
	}
	public void setNumeroSocio(Long numeroSocio) {
		this.numSocio = numeroSocio;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}