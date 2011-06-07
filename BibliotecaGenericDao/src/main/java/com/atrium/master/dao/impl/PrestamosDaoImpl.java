package com.atrium.master.dao.impl;

import org.springframework.stereotype.Repository;

import com.atrium.master.dao.PrestamosDao;
import com.atrium.master.pojos.Prestamo;

@Repository
public class PrestamosDaoImpl extends GenericHibernateDaoImpl<Prestamo, Long>
		implements PrestamosDao {
}
