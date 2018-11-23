package com.ipartek.formacion.editorialrestspring.apirest;

import java.util.List;

public interface RestAble<T> {
	
	public List<T> obtenerTodos();
	
	public T obtenerPorId(Long id);
	
	public Long crear(T t);
	
	public void modificar(T t);
		
	public void borrar(Long id);
}
