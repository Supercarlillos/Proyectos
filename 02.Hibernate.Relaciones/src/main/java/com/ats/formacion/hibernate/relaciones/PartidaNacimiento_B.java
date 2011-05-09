package com.ats.formacion.hibernate.relaciones;

public class PartidaNacimiento_B {
	Persona p;
	int id;
	String numero;
	char letra;
	
	public PartidaNacimiento_B() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PartidaNacimiento_B(String numero, char letra) {
		super();
		this.numero = numero;
		this.letra = letra;
	}


	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Persona getP() {
		return p;
	}


	public void setP(Persona p) {
		this.p = p;
	}

}
