package com.ipartek.formacion.springrestcrud.repositories;

import java.util.List;

import com.ipartek.formacion.springrestcrud.entidades.Usuario;

public interface CrudAble<T> {

	public List<T> getAll();
	public T getById(Long id);
	public void insert(T t); //Devolver el id insertado
	public void update(T t);
	public void delete(Long id);
	List<Usuario> getUsuarioLogin(Usuario usuario);

}
