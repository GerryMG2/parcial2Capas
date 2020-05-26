package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class libroDato {

	@PersistenceContext(unitName = "capas")
	private EntityManager entity;
	
	
	public List<libro> getAll(){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from cat_libro;");
		Query qr = entity.createNativeQuery(sb.toString(), libro.class);
	
		return qr.getResultList();
	}
	
	
	@Transactional
	public boolean save(libro l) {
		try {
			entity.persist(l);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
			return false;
		}
	}
	
}
