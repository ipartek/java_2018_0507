package com.ipartek.formacion.ejercicios.repositories;

import java.util.List;

public interface CrudAble<T> {

	public List<T> getAll();
	public T getById(Long id);
	public T Validar(T t);
	public void insert(T t); 
	public void update(T t);
	public void delete(Long id);
}
