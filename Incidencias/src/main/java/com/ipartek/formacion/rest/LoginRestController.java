package com.ipartek.formacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejercicios.modelo.Usuario;
import com.ipartek.formacion.ejercicios.repositories.CrudAble;

@RestController
public class LoginRestController implements CrudAble<Usuario> {

	@Autowired
	private CrudAble<Usuario> repositorio;

	@PostMapping("/api/login")
	public Usuario usu(@RequestBody Usuario usu) {
		return usu;
	}

	@GetMapping("/api/login")
	public List<Usuario> getAll() {
		return repositorio.getAll();
	}

	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
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
