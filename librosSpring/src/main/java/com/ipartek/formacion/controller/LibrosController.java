package com.ipartek.formacion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.model.Libro;
import com.ipartek.formacion.repositories.LibroMapRepository;

@Controller
public class LibrosController {
	@Autowired
	private final LibroMapRepository repositorio = null;

	@GetMapping("/libros")
	public String getAll(Model modelo) {
		modelo.addAttribute("libros", repositorio.getAll());
		return "libros";
	}

	@GetMapping("/libroEditar/{accion}/{id}")
	public String accionesLibros(@PathVariable(name = "id", required = false) Long id,
			@PathVariable("accion") String accion, Model modelo,Libro libro) {
	
		switch (accion) {
		case "nuevoLibroModal":
			modelo.addAttribute("nuevoLibro", true);	
		case "editarModal":
			modelo.addAttribute("updateLibro", true);
			modelo.addAttribute("libro", repositorio.getById(id));
		default:
			break;
		}
		return getAll(modelo);
	}

	@PostMapping("libroEditar/{accion}/{id}")
	public String accionesLibros(@Valid Libro libro,
			@PathVariable(name = "id", required = false) Long id, @PathVariable("accion") String accion, Model modelo) {
	switch (accion) {
	case "add":
		repositorio.insert(libro);		
		break;
	default:
		break;
	}
		return getAll(modelo);
	}
}
