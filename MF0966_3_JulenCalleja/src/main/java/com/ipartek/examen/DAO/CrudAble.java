package com.ipartek.examen.DAO;

import java.util.List;

public interface CrudAble <T> {

	List<T> getAll();
	
	T getById(int id);
	
	void insert(T pojo);
	void update(T pojo);
	
}
