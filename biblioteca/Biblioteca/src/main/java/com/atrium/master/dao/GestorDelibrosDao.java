package com.atrium.master.dao;

import java.util.List;
import com.atrium.master.modelo.Libro;

public interface GestorDelibrosDao {

	public List<Libro> obtenerListadoLibrosDisponibles();

	public Libro agregarLibroNuevo(Libro libroNuevo);

	public Libro modificarDatosLibro(Libro libroNuevo);

	public Libro obtenerLibroPorId(Long id);

	public int borrarLibroPorId(long id);

}
