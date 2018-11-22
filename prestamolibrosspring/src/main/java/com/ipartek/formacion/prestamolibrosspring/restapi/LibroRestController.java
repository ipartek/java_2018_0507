package com.ipartek.formacion.prestamolibrosspring.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibrosspring.model.Libro;
import com.ipartek.formacion.prestamolibrosspring.repositories.CrudAble;

@RestController
public class LibroRestController {
	@Autowired
	private CrudAble<Libro> repositorio;
	
	@GetMapping("/api/libros")
	public List<Libro> obtenerLibros() {
		return repositorio.getAll();
	}
	
	@GetMapping("/api/libros/{idrecibido}")
	public Libro obtenerLibroPorId(@PathVariable("idrecibido") Long id) {
		return repositorio.getById(id);
	}
	
	@PostMapping("/api/libros")
	public Long crearNuevoLibro(@RequestBody Libro libro) {
		return repositorio.insert(libro);
	}
	
	@PutMapping("/api/libros")
	public void cambiarLibro(@RequestBody Libro libro) {
		repositorio.update(libro);
	}
	
	@DeleteMapping("/api/libros/{id}")
	public void borrarLibro(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}
}