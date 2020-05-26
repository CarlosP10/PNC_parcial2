package com.uca.labo5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.labo5.domain.Categoria;
import com.uca.labo5.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {
	@PersistenceContext(unitName="labo5")
	private EntityManager entityManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro ");
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> resulset= query.getResultList();		
		return resulset;
	}

	@Transactional
	public void insertar(Libro l) throws DataAccessException {
		if(l.getCodigoLibro() == null) { 
			entityManager.persist(l);
		}
		else { 
			entityManager.merge(l); 
		}	
	}

}
