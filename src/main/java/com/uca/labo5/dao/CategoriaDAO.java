package com.uca.labo5.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.labo5.domain.Categoria;
import com.uca.labo5.domain.Libro;

public interface CategoriaDAO {
	public List<Categoria> findAll() throws DataAccessException;
	public void insertar(Categoria c) throws DataAccessException;

}
