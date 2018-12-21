package com.ipartek.formacion.ejercicios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejercicios.modelos.Usuario;
import com.ipartek.formacion.ejercicios.repositories.CrudAble;


@RestController
public class LoginRest implements CrudAble<Usuario> {

	@Autowired
	private CrudAble<Usuario> repositorio;
	
	@GetMapping("/api/login")
	public List<Usuario> getAll() {
		return repositorio.getAll();
	}

	@GetMapping("/api/login/{id}")
	public Usuario getById(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	public void insert(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
