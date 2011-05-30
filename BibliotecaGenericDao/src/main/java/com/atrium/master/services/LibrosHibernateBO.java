package com.atrium.master.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.atrium.master.dao.LibrosDao;
import com.atrium.master.pojos.Libro;
import com.atrium.master.services.helper.PojosJDBCTest.LibroPojoJDBCTest;

@Service
public class LibrosHibernateBO {

	@Inject
	private LibrosDao librosDAO;

	public Long createLibro(Libro libro) {
		return librosDAO.insert(libro);
	}

	public Libro findLibroById(Long id) {
		return librosDAO.retrieve(id);
	}

	public List<Libro> listAll() {
		return librosDAO.findAll();
	}

	public void update(Libro libro) {
		librosDAO.update(libro);

	}

	public void delete(Libro libro) {
		librosDAO.delete(libro);
		
	}

}
