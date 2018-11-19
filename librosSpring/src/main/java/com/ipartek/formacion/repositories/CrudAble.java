package com.ipartek.formacion.repositories;

import java.util.List;

public interface CrudAble<T> {
	public List<T> getAll();
	public T getById(Long id);
	public Long insert(T t); //Devolver el id insertado
	public void update(T t);
	public void delete(Long id);	
}
