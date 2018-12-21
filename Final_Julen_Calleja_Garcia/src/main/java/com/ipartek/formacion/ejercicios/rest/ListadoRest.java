package com.ipartek.formacion.ejercicios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.ejercicios.modelos.Producto;
import com.ipartek.formacion.ejercicios.repositories.CrudAble;

public class ListadoRest implements CrudAble<Producto> {
	
	@Autowired
	private CrudAble<Producto> repositorio;

	@GetMapping("/api/listado")
	public List<Producto> getAll() {
		return repositorio.getAll();
	}

	@Override
	public Producto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto Validar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("api/listado")
	public void insert(Producto pro) {
		repositorio.insert(pro);
		
	}

	@Override
	public void update(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@DeleteMapping("/api/listado/{id}")
	public void delete(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}

}
