package com.ipartek.formacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ipartek.formacion.model.Libro;
import com.ipartek.formacion.repositories.CrudAble;



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
	public Long crearNuevoLibro(@RequestBody Libro editorial) {
		return repositorio.insert(editorial);
	}
	
	@PutMapping("/api/libros")
	public void cambiarLibros(@RequestBody Libro editorial) {
		repositorio.update(editorial);
	}
	
	@DeleteMapping("/api/libros/{id}")
	public void borrarLibros(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}
}
