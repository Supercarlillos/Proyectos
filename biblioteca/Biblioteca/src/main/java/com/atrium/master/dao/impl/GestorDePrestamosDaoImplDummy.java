package com.atrium.master.dao.impl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import com.atrium.master.dao.GestorDePrestamosDao;
import com.atrium.master.modelo.Prestamo;
import com.atrium.master.modelo.Usuario;


public class GestorDePrestamosDaoImplDummy implements GestorDePrestamosDao {

	@Inject
	private Prestamo prestamoNuevo;

	private List<Prestamo> listadoPrestamosDummy = new ArrayList<Prestamo>();

	public boolean aniadirPrestamo(Prestamo prestamo) {
		//prestamoNuevo.setIdentificador(prestamo.getIdentificador());
		prestamoNuevo.setNumeroSocio(prestamo.getNumeroSocio());
		prestamoNuevo.setFechaSalida(convertirStringADate("2011-04-17"));
		prestamoNuevo.setFechaLimiteEntrega(convertirStringADate("2011-06-17"));
		listadoPrestamosDummy.add(prestamoNuevo);
		return true;
	}

	public boolean actualizarFechaDevolucion(Prestamo prestamo) {
		for (Prestamo aux : listadoPrestamosDummy)
			if (esIgualPrestamo(prestamo, aux)) {
				aux.setFechaEntrega(convertirStringADate("2012-04-17"));
				return true;
			}
		return false;
	}

	public List<Prestamo> consultaHistoricoPrestamos(Usuario usuario) {
		return listadoPrestamosDummy;
		
	}

	private boolean esIgualPrestamo(Prestamo prestamo, Prestamo aux) {
		return (aux.getIdentificador() == prestamo.getIdentificador())
				&& (aux.getNumeroSocio() == prestamo.getNumeroSocio());
	}

	private Date convertirStringADate(String fechaString) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatoDelTexto.parse(fechaString);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Prestamo> consultaHistoricoPrestamosPorNumSocio(long numSocio) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Prestamo> consultaHistoricoPrestamosPorIdentificadorLibro(
			Long identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	public int aniadirPrestamo(Long identificadorLibro, Long numSocio,
			java.sql.Date diaAlta) {
		// TODO Auto-generated method stub
		return (Integer) null;
	}
}
