package com.app.attore;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.util.*;

@Transactional
@Repository
public class AttoreDAO {
	@PersistenceContext	
    private EntityManager entityManager;	
    @SuppressWarnings("unchecked")
    
	public List<Attore> getAttori() {
		String hql = "FROM Attore";
		return (List<Attore>) entityManager.createQuery(hql).getResultList();
	}
    
	public Attore getAttore(Long codAttore){
		return (Attore) entityManager.find(Attore.class,codAttore);
	}
	
	public void modAttore(Attore attore) {
		if (attore.getCodAttore()!=-1) {
			Attore attoreLocal = getAttore(attore.getCodAttore());
			if (attoreLocal!=null){
				attoreLocal.setNome(attore.getNome());
				attoreLocal.setAnnoNascita(attore.getAnnoNascita());
				attoreLocal.setNazionalita(attore.getNazionalita());
				entityManager.flush();
			}
		}
		else{
			attore.setCodAttore((long)0);
			entityManager.persist(attore);
		}
	}
	
	public void delAttore(Long codAttore) {
		entityManager.remove(getAttore(codAttore));
	}
		//    query.setParameter("nRows", pageSize);
	   // query.setParameter("nPages", pageSize);
	public List<Attore> getDataRows(String tableName, Integer pageIndex , Integer pageSize) {
		Query query = entityManager.createNamedStoredProcedureQuery("getDataRows"); //createNamedQuery
	    query.setParameter("tableName", tableName);
	    query.setParameter("pageIndex", pageIndex);
	    query.setParameter("pageSize", pageSize);

		return (List<Attore>) query.getResultList();
	}
	public ClsnRownPages getnRowsnPages(String tableName, Integer pageIndex , Integer pageSize) {
		Query query = entityManager.createNamedStoredProcedureQuery("getnrowsnpages"); //createNamedQuery
	    query.setParameter("tableName", tableName);
	    query.setParameter("pageIndex", pageIndex);
	    query.setParameter("pageSize", pageSize);
	    query.executeUpdate();
		return (ClsnRownPages) query.getSingleResult(); //getResultList();
	}
    
}
