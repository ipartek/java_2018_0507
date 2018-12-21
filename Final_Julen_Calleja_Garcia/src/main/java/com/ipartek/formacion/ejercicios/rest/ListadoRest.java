package com.ipartek.formacion.ejercicios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejercicios.modelos.Producto;
import com.ipartek.formacion.ejercicios.repositories.CrudAble;

@RestController
public class ListadoRest implements CrudAble<Producto> {
	
	@Autowired
	private CrudAble<Producto> repositorio;

	@GetMapping("/api/listado")
	public List<Producto> getAll() {
		return repositorio.getAll();
	}

	@GetMapping("/api/listado/{id}")
	public Producto getById(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	public Producto Validar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("api/listado")
	public void insert(@RequestBody Producto pro) {
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
