package com.ipartek.formacion.incidencias.repositorios;

import java.util.List;

public interface CrudAble<T> {
	public List<T> getAll();
	public T getById(Long id);
	public Long insert(T t);
	public void update(T t);
	public void delete(Long id);	
}