package com.atrium.master.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import javax.inject.Inject;
import org.springframework.context.MessageSource;
import com.atrium.master.dao.GestorDelibrosDao;
import com.atrium.master.excepciones.ErrorException;
import com.atrium.master.modelo.Libro;



public class GestorDeLibrosDaoImplDummy implements GestorDelibrosDao{
	@Inject
	private Libro libro1, libro2, libro3, libroNuevo;
	@Inject
	private MessageSource fuenteDeMensajes; 
	
	private List<Libro> librosDisponiblesDummy=new ArrayList<Libro>();
	
	private Locale locale = new Locale("es");

	public GestorDeLibrosDaoImplDummy() {
		// TODO Auto-generated constructor stub
	}

	public List<Libro> obtenerListadoLibrosDisponibles() {
		return librosDisponiblesDummy;
	}

	public Libro agregarLibroNuevo(Libro libro) {
		libroNuevo = libro;
		validarCamposLibroNuevo();
		//libroNuevo.setIdentificador(librosDisponiblesDummy.size() + 1);
		librosDisponiblesDummy.add(libroNuevo);
		return libroNuevo;
	}

	public Libro modificarDatosLibro(Libro libro){
		libroNuevo=libro;
		validarCamposLibroNuevo();
		for (Libro aux : librosDisponiblesDummy) {
			if (coincidenIndentificadores(libroNuevo, aux)) {
				actualizarDatosLibro(aux);
				return aux;
			}
		}
		lanzarExceptionLibroNoExiste();
		return libroNuevo;
	}
	
	public boolean borrarLibro(Libro libro) {
		libroNuevo=libro;
		for (Libro aux : librosDisponiblesDummy) {
			if (libro.equals(aux)) {
				librosDisponiblesDummy.remove(aux);
				return true;
			}
		}
		lanzarExceptionLibroNoExiste();
		return false;

	}

	private void lanzarExceptionLibroNoExiste() {
		String str[] = { libroNuevo.toString()};
		String mensaje = fuenteDeMensajes.getMessage("ErrorNoExisteLibro", str,
				locale);		
		throw new ErrorException(mensaje);
		
	}

	private void actualizarDatosLibro(Libro aux) {
		librosDisponiblesDummy.remove(aux);
		librosDisponiblesDummy.add(libroNuevo);
	}

	private boolean coincidenIndentificadores(Libro Libro, Libro aux) {
		return aux.getIdentificador() == Libro.getIdentificador();
	}

	private void validarCamposLibroNuevo() {
		if (!esAutorValido()) {
			lanzarExceptionValidacion("Autor");
		}
		if (!esIsbValido()) {
			lanzarExceptionValidacion("Isb");
		}
		if (!esTituloValido()) {
			lanzarExceptionValidacion("Titulo");
		}
		if (!esSipnosisValido()) {
			lanzarExceptionValidacion("Sipnosis");
		}
	}

	private void lanzarExceptionValidacion(String causa) {
		String str[] = { libroNuevo.toString(), "falta Campo" + causa };
		String mensaje = fuenteDeMensajes.getMessage("ErrorValidacionLibro", str,
				locale);		
		throw new ErrorException(mensaje);
	}

	private boolean esSipnosisValido() {
		return ((libroNuevo.getSipnosis() != "") && (libroNuevo.getSipnosis() != null));
	}

	private boolean esTituloValido() {
		return ((libroNuevo.getTitulo() != "") && (libroNuevo.getTitulo() != null));
	}

	private boolean esIsbValido() {
		return ((libroNuevo.getIsb() != "") && (libroNuevo.getIsb() != null));
	}

	private boolean esAutorValido() {
		return ((libroNuevo.getAutor() != "") && (libroNuevo.getAutor() != null));
	}

	@SuppressWarnings("unused")
	private void inicioVariablesDummies() {

		//libro1.setIdentificador(1);
		libro1.setIsb("0000000000001");
		libro1.setTitulo("EjemploLibro1");
		libro1.setAutor("Anonimo");
		libro1.setSipnosis("un libro muy divertido");

		//libro2.setIdentificador(2);
		libro2.setIsb("0000000000002");
		libro2.setTitulo("EjemploLibro2");
		libro2.setAutor("Anonimo");
		libro2.setSipnosis("un libro muy aburrido");

		//libro3.setIdentificador(3);
		libro3.setIsb("0000000000003");
		libro3.setTitulo("EjemploLibro3");
		libro3.setAutor("Anonimo");
		libro3.setSipnosis("un libro muy aburrido");

		librosDisponiblesDummy.add(libro1);
		librosDisponiblesDummy.add(libro2);
		librosDisponiblesDummy.add(libro3);

	}

	public Libro obtenerLibroPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int borrarLibroPorId(long id) {
		// TODO Auto-generated method stub
		return 1;
	}


}
