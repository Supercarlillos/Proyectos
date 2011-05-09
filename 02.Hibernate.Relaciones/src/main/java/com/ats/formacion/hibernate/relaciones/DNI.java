package com.ats.formacion.hibernate.relaciones;

public class DNI {
	int id;
	String numero;
	char letra;
	
	public DNI() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DNI(String numero, char letra) {
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

}
