package com.ats.formacion.hibernate.relaciones;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Usuario {
	int id;
	
	String login;
	String password;
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	



	public Usuario(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
