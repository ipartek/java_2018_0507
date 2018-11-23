package com.ipartek.formacion.editorialrestspring.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.editorialrestspring.modelos.Libro;
import com.ipartek.formacion.editorialrestspring.repositories.CrudAble;

@RestController
public class LibroRestController implements RestAble<Libro>{

	@Autowired
	private CrudAble<Libro> repositorio;
	
	@Override
	@GetMapping("/api/libros")
	public List<Libro> obtenerTodos() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/libros/{id}")
	public Libro obtenerPorId(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/libros")
	public Long crear(@RequestBody Libro libro) {
		return (Long) repositorio.insert(libro);
	}

	@Override
	@PutMapping("/api/libros")
	public void modificar(@RequestBody Libro libro) {
		repositorio.update(libro);
	}

	@Override
	@DeleteMapping("/api/libros/{id}")
	public void borrar(Long id) {
		repositorio.delete(id);
	}
}
