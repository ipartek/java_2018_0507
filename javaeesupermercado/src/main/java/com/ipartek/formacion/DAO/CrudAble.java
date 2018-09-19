package com.ipartek.formacion.DAO;

import java.util.List;

import com.ipartek.formacion.pojo.supermercado.Botella;

public interface CrudAble <B> {
	
	List <B> getAll();
	
	Botella getById(long id);
	
	boolean insert(B pojo);
	boolean update(B pojo);
	boolean delete(long id);

	
	
	
}
