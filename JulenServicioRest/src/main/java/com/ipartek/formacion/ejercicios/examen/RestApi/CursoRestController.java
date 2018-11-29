package com.ipartek.formacion.ejercicios.examen.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejercicios.examen.modelo.Curso;

@RestController
public class CursoRestController implements RestAble<Curso> {

	@Autowired
	private RestAble<Curso> repositorio; 
	
	
	@GetMapping("api/cursos")
	public List<Curso> GetAll() {
		return repositorio.GetAll();
	}

	@GetMapping("api/cursos/{id}")
	public Curso GetById(@PathVariable("id") Long id) {
		return repositorio.GetById(id);
	}

}
