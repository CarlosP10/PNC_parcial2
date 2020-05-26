package com.uca.labo5.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.labo5.domain.Importancia;

public interface ImportanciaDAO {

	public List<Importancia> findAll() throws DataAccessException;
	
	public Importancia findOne(Integer code) throws DataAccessException;

}
