package com.atrium.master.dao;

import org.springframework.stereotype.Repository;

import com.atrium.master.pojos.Libro;

@Repository
public interface LibrosDao extends GenericDao<Libro, Long> {
}
