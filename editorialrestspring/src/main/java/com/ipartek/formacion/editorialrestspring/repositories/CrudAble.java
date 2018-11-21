package com.ipartek.formacion.editorialrestspring.repositories;

import java.util.List;

public interface CrudAble<T> {
	public List<T> getAll();
	public T getById(Long id);
	public Long insert(T t); //Devolver el id insertado
	public boolean update(T t);
	public boolean delete(Long id);	
}
