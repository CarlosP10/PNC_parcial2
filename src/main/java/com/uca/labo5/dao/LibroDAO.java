package com.uca.labo5.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.labo5.domain.Libro;

public interface LibroDAO {
	public List<Libro> findAll() throws DataAccessException;
	public void insertar(Libro l) throws DataAccessException;
}
