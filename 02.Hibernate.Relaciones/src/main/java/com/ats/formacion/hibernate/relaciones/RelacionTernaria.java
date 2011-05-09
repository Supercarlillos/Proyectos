package com.ats.formacion.hibernate.relaciones;

public class RelacionTernaria {
	Usuario u;
	Alquiler a;
	Persona p;
	public RelacionTernaria() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RelacionTernaria(Usuario u, Alquiler a, Persona p) {
		super();
		this.u = u;
		this.a = a;
		this.p = p;
	}



	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	}
	public Alquiler getA() {
		return a;
	}
	public void setA(Alquiler a) {
		this.a = a;
	}
	public Persona getP() {
		return p;
	}
	public void setP(Persona p) {
		this.p = p;
	}
}
