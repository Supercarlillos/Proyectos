package com.atrium.master.dao;

import java.sql.Date;
import java.util.List;
import com.atrium.master.modelo.Prestamo;

public interface GestorDePrestamosDao {

	public boolean actualizarFechaDevolucion(Prestamo prestamo);

	public List<Prestamo> consultaHistoricoPrestamosPorNumSocio(long numSocio);

	public List<Prestamo> consultaHistoricoPrestamosPorIdentificadorLibro(Long identificador);

	public int aniadirPrestamo(Long identificadorLibro, Long numSocio, Date diaAlta);

}
