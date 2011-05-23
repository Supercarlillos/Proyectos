package com.atrium.master.services;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.atrium.master.dao.PrestamosDao;


@Service
public class PrestamosBO {
	
	@Inject
	private  PrestamosDao gestorDePrestamosDao;

	/*public int aniadirPrestamo(Long identificadorLibro, Long numSocio, Date diaAlta) {
		return gestorDePrestamosDao.aniadirPrestamo(identificadorLibro,numSocio,diaAlta);	
	}

	public boolean actualizarFechaDevolucion(Prestamo prestamo) {
		return gestorDePrestamosDao.actualizarFechaDevolucion(prestamo);
	}

	public List<Prestamo> consultaHistoricoPrestamosPorNumSocio(long numSocio) {
		return gestorDePrestamosDao.consultaHistoricoPrestamosPorNumSocio(numSocio);
	}

	public List<Prestamo> consultaHistoricoPrestamosPorIdentificadorLibro(
			Long identificador) {
		return gestorDePrestamosDao.consultaHistoricoPrestamosPorIdentificadorLibro(identificador);
	}*/

}
