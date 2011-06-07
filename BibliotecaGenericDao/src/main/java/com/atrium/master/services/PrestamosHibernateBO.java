package com.atrium.master.services;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.atrium.master.dao.PrestamosDao;
import com.atrium.master.pojos.Prestamo;


@Service
public class PrestamosHibernateBO {
	
	@Inject
	private  PrestamosDao gestorDePrestamosDao;

	public Long createPrestamo(Prestamo prestamo) {
		return gestorDePrestamosDao.insert(prestamo);
	}

	public Prestamo findPrestamoById(Long id) {
		return gestorDePrestamosDao.retrieve(id);
	}

	public List<Prestamo> listAll() {
		return gestorDePrestamosDao.findAll();
	}

	public void update(Prestamo prestamo) {
		gestorDePrestamosDao.update(prestamo);

	}

	public void delete(Prestamo Prestamo) {
		gestorDePrestamosDao.delete(Prestamo);

	}
}
