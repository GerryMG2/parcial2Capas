package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class categoriaDao implements categoriaInterface {
	
	@PersistenceContext(unitName = "capas")
	private EntityManager entity;

	@Override
	public List<categoria> getall() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from cat_categoria;");
		Query qr = entity.createNativeQuery(sb.toString(), categoria.class);
	
		return qr.getResultList();
	}

	@Transactional
	@Override
	public boolean InsertCategoria(categoria cat) throws DataAccessException {
		
		try {
			
			System.out.println("entra a salvar la categoria " + cat.getCategoria() );
			entity.persist(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
			// TODO: handle exception
		}
		
	}

}
