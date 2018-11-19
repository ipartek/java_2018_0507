package com.ipartek.formacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ipartek.formacion.model.Libro;
import com.ipartek.formacion.repositories.CrudAble;



@RestController
public class LibroRestController {
	@Autowired
	private CrudAble<Libro> repositorio;
	@GetMapping("/api/libros")
	public List<Libro> obtenerEditoriales() {
		return repositorio.getAll();
	}
}
