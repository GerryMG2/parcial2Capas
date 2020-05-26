package com.example.demo;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceLibro {
	
	@Autowired
	libroDato dao = new libroDato();
	
	public List<libro> getLibros(){
		return dao.getAll();
	}
	
	@Transactional
	public boolean save(libro l) {
		return dao.save(l);
	}
	
	
}
