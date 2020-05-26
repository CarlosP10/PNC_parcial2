package com.uca.labo5.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.labo5.domain.Contribuyente;

public interface ContrubyenteDAO {

	public List<Contribuyente> findAll() throws DataAccessException;
	public void insertar(Contribuyente e) throws DataAccessException;

}
