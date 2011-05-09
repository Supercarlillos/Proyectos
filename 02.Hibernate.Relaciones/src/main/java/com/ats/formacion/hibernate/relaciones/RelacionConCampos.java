package com.ats.formacion.hibernate.relaciones;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class RelacionConCampos {
		
	Date fecha;
	String nombre;
	Alquiler alquiler;
	Persona p;
	
	public RelacionConCampos() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}




	public RelacionConCampos(Date fecha, String nombre) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
	}




	public Alquiler getAlquiler() {
		return alquiler;
	}




	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}




	public Persona getP() {
		return p;
	}




	public void setP(Persona p) {
		this.p = p;
	}

}
