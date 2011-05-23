package com.atrium.master.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.atrium.master.dao.LibrosDao;
import com.atrium.master.pojos.Libro;

@Service
public class LibrosHibernateBO {
	
	@Inject
	private LibrosDao librosDAO;

	public Long createLibro(Libro libroTest) {
		return librosDAO.insert(libroTest);	
	}
	
	public Libro findLibroById(Long id) {
		return librosDAO.retrieve(id);	
	}

}
