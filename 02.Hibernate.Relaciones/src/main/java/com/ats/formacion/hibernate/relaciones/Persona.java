package com.ats.formacion.hibernate.relaciones;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


public class Persona {
	int id;
	String nombre;
	//1.- ONETOONE MISMA CLAVE
	DNI dni;
	
	//2.- ONETOONE con Columna join 
	PartidaNacimiento partida;
	
	//3.- ONE2MANY por columna
	Set<Vehiculo> vehiculo=new HashSet<Vehiculo>();
	
	//4.- ONE2MANY por tabla
	Set<Alquiler> alquileres=new HashSet<Alquiler>();
	
	//5.- MANY2MANY
	Set<Direccion> direcciones=new HashSet<Direccion>();
	
	//6.- MANYTOONE con tabla join 
	PartidaNacimiento2 partida2;
	
	//7.- ONETOONE BIDIR
	DNI_B dni_b;
	
	//8 ONETOONE con Columna join bidirecional
	PartidaNacimiento_B partida_b;
	
	//9.- ONE2MANY por columna bidirecional
	Set<Vehiculo_B> vehiculo_b=new HashSet<Vehiculo_B>();
	
	//10.- ONE2MANY por tabla bidirecional
	Set<Alquiler_B> alquileres_b=new HashSet<Alquiler_B>();
	
	//11.- MANY2MANY
	Set<Direccion_B> direcciones_b=new HashSet<Direccion_B>();
	
	//12.-  ONE2MANY por tabla con CAMPOS EN LA RELACION
	Set<RelacionConCampos> alquileres_extra=new HashSet<RelacionConCampos>();

	//12.-  ONE2MANY por tabla con CAMPOS EN LA RELACION
	Set<RelacionTernaria> alquileres_extra_ternario=new HashSet<RelacionTernaria>();
	
	

	

	public Set<RelacionConCampos> getAlquileres_extra() {
		return alquileres_extra;
	}

	public void setAlquileres_extra(Set<RelacionConCampos> alquileres_extra) {
		this.alquileres_extra = alquileres_extra;
	}

	
	public PartidaNacimiento_B getPartida_b() {
		return partida_b;
	}

	public void setPartida_b(PartidaNacimiento_B partida_b) {
		partida_b.p=this;
		this.partida_b = partida_b;
	}

	public Persona(String nombre, DNI dni, PartidaNacimiento partida,
			PartidaNacimiento2 partida2) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.partida = partida;
		this.partida2 = partida2;
	}

	public PartidaNacimiento getPartida() {
		return partida;
	}

	public void setPartida(PartidaNacimiento partida) {
		this.partida = partida;
	}

	public Persona(String nombre, DNI dni, PartidaNacimiento partida) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.partida = partida;
	}

	public Persona(String nombre, DNI dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public DNI getDni() {
		return dni;
	}

	public void setDni(DNI dni) {
		this.dni = dni;
	}

	public Persona(String nombre ) {
		super();
		this.nombre = nombre;
		
	}

	public Persona() {
	
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

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Vehiculo> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Set<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Set<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(Set<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public PartidaNacimiento2 getPartida2() {
		return partida2;
	}

	public void setPartida2(PartidaNacimiento2 partida2) {
		this.partida2 = partida2;
	}

	public DNI_B getDni_b() {
		return dni_b;
	}

	public void setDni_b(DNI_B dni_b) {
		this.dni_b = dni_b;
	}

	public Set<Alquiler_B> getAlquileres_b() {
		return alquileres_b;
	}

	public void setAlquileres_b(Set<Alquiler_B> alquileres_b) {
		this.alquileres_b = alquileres_b;
	}

	public void addAquiler_b(Alquiler_B alquiler_B) {
		getAlquileres_b().add( alquiler_B);
//		alquiler_B.setP(this);
		
		
	}

	public Set<Vehiculo_B> getVehiculo_b() {
		return vehiculo_b;
	}

	public void setVehiculo_b(Set<Vehiculo_B> vehiculo_b) {
		this.vehiculo_b = vehiculo_b;
	}

	public void addVehiculo_B(Vehiculo_B vehiculo_B2) {
		
		//metodo de conveniencia para ajustar ambos lados de la relacion...
		vehiculo_B2.setP(this);
		vehiculo_b.add(vehiculo_B2);
		
	}

	public Set<Direccion_B> getDirecciones_b() {
		return direcciones_b;
	}

	public void setDirecciones_b(Set<Direccion_B> direcciones_b) {
		this.direcciones_b = direcciones_b;
	}

	public void addDireccion_B(Direccion_B direccion_B) {
		//ojo que son dos listas
		direccion_B.getPersonas().add(this);
		direcciones_b.add(direccion_B);
		
	}

	public void addAquiler_ExtraInfo(Alquiler alquiler) {
		RelacionConCampos campos = new RelacionConCampos(new Date(),User.getCurrentUser());
		campos.setP(this);
		campos.setAlquiler(alquiler);
		alquileres_extra.add(campos );
	}

	public Set<RelacionTernaria> getAlquileres_extra_ternario() {
		return alquileres_extra_ternario;
	}

	public void setAlquileres_extra_ternario(
			Set<RelacionTernaria> alquileres_extra_ternario) {
		this.alquileres_extra_ternario = alquileres_extra_ternario;
	}

	public void addAlquiler_Ternario(Alquiler alquiler) {
		RelacionTernaria rt = new RelacionTernaria(new Usuario("pepe","pepe"),alquiler,this);
		alquileres_extra_ternario.add(rt);
	}



	
	
	
}
