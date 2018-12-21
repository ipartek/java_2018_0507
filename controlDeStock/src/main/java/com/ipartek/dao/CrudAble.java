package com.ipartek.dao;

import java.util.List;

import com.ipartek.modelos.Producto;

public interface CrudAble<T> {
	public List<T> getAll();
	public T getById(Long id);
	public Long insert(T t); //Devolver el id insertado
	public void update(T t);
	public void delete(Long id);
}
