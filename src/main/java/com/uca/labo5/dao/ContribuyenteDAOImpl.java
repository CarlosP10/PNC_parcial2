package com.uca.labo5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.labo5.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContrubyenteDAO{
	
	@PersistenceContext(unitName="labo5")
	private EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente ");
		Query query = entityManager.createNativeQuery(sb.toString(),Contribuyente.class);
		List<Contribuyente> resulset= query.getResultList();		
		return resulset;
	}

	
	@Transactional
	public void insertar(Contribuyente e) throws DataAccessException {
		if(e.getC_contri() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}	
	}

}
