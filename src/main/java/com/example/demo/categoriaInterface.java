package com.example.demo;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface categoriaInterface {

	public List<categoria> getall() throws DataAccessException;
	public boolean InsertCategoria(categoria cat) throws DataAccessException;
	
}
