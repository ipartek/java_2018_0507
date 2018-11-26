package com.ipartek.formacion.prestamolibrosspring.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibrosspring.model.Libro;


@RestController
public class LibroRestController implements RestAble<Libro> {
	@Autowired
	private RestAble<Libro> repositorio;

	@GetMapping("/api/libros")
	public List<Libro> obtenerTodos() {
		return repositorio.obtenerTodos();
	}


	@Override
	public Libro obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long crear(Libro t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Libro t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
