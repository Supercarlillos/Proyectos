package com.atrium.master.dao.impl;

import org.springframework.stereotype.Repository;

import com.atrium.master.dao.LibrosDao;
import com.atrium.master.pojos.Libro;

@Repository
public class LibrosDaoImpl extends GenericHibernateDaoImpl<Libro, Long> implements LibrosDao {

}
