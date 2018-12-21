package com.ipartek.formacion.tienda.apirest;

import java.util.List;

public interface RestAble<T> {
	
	public List<T> obtenerTodos();
	
	public T obtenerPorId(Long id);
	
	public void crear(T t);
	
	public void modificar(T t);
		
	public void borrar(Long id);
}
