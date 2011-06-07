package com.atrium.master.services.helper.PojosJDBCTest;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PrestamoPojoJDBCTest implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Date fechaSalida;
	private Date fechaLimiteEntrega;
	private Date fechaEntrega;

	public PrestamoPojoJDBCTest() {
	}

	public PrestamoPojoJDBCTest(Date fechaSalida, Date fechaLimiteEntrega, Date fechaEntrega) {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
