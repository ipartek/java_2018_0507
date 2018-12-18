package com.ipartek.formacion.springrestcrud.repositories;

import java.util.List;

import com.ipartek.formacion.springrestcrud.entidades.Comentario;
import com.ipartek.formacion.springrestcrud.entidades.Incidencia;
import com.ipartek.formacion.springrestcrud.entidades.Usuario;

public interface CrudAble<T> {

	public List<T> getAll();
	public T getById(Long id);
	public void insert(T t); //Devolver el id insertado
	public void update(T t);
	List<T> getUsuarioLogin(Usuario usuario);
	public List<T> getByEquipo(String equipo);
	public List<Incidencia> getByUsuario(String usuario);
	public List<Incidencia> getByEstado(String estado);
	public List<Comentario> getByIdIncidencia(String incidencia_id);

}
