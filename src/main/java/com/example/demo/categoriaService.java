package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoriaService {
	
	@Autowired
	categoriaDao cate = new categoriaDao();
	
	public List<categoria> getAll() {
		return cate.getall();
	}
	
	@Transactional
	public boolean save(categoria cat) {
		return cate.InsertCategoria(cat);
	}

}
