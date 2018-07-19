package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;

public interface CrudAble<B> {

	
	List<B> getAll();
	B getById(long id);
	boolean insert(Libro libro);
	boolean update(Libro libroUpdate);
	boolean delete(long id);
	boolean insert(Cliente cliente);
	
	
	
}
