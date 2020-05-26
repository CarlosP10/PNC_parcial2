package com.uca.labo5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.labo5.domain.Categoria;
import com.uca.labo5.domain.Contribuyente;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	@PersistenceContext(unitName="labo5")
	private EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria ");
		Query query = entityManager.createNativeQuery(sb.toString(),Categoria.class);
		List<Categoria> resulset= query.getResultList();		
		return resulset;
	}

	@Transactional
	public void insertar(Categoria c) throws DataAccessException {
		if(c.getcCategoria() == null) { 
			entityManager.persist(c);
		}
		else { 
			entityManager.merge(c); 
		}			
	}

}
