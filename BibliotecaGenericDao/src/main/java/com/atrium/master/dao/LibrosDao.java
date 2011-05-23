package com.atrium.master.dao;

import org.springframework.stereotype.Repository;

import com.atrium.master.pojos.Libro;

@Repository
public interface LibrosDao extends GenericDao<Libro, Long>{
	
// Metodos utilizados no forman parte del GenericDao
//	public List<Libro> obtenerListadoLibrosDisponibles();
//	public Libro agregarLibroNuevo(Libro libroNuevo);
//	public Libro modificarDatosLibro(Libro libroNuevo);
//	public Libro obtenerLibroPorId(Long id);
//	public int borrarLibroPorId(long id);

}
