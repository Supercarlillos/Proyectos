package com.atrium.master.services;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.atrium.master.dao.LibrosDao;

@Service
public class LibrosBO {
	
	@Inject
	private LibrosDao gestorDeLibrosDao;

//	public List<Libro> obtenerListadoLibrosDisponibles() {
//		return gestorDeLibrosDao.obtenerListadoLibrosDisponibles();
//	}
//
//	public Libro agregarLibroNuevo(Libro libro) {
//		return gestorDeLibrosDao.agregarLibroNuevo(libro);
//	}
//
//	public Libro modificarDatosLibro(Libro libro) {
//		return gestorDeLibrosDao.modificarDatosLibro(libro);
//	}
//
//	public Libro obtenerLibroPorId(Long id) {
//		return gestorDeLibrosDao.obtenerLibroPorId(id);
//	}
//
//	public int borrarLibroPorId(long id) {
//		return gestorDeLibrosDao.borrarLibroPorId(id);	
//	}

}
