package com.ipartek.formacion.prestamolibrosspring.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.prestamolibrosspring.model.Libro;
import com.ipartek.formacion.prestamolibrosspring.repositories.LibroMapRepository;

@Controller
public class LibroController {

	public static final LibroMapRepository repositorioLibro = new LibroMapRepository();

	static {
		repositorioLibro.insert(new Libro(1L, "El nombre del viento", "Es un gay"));
		repositorioLibro.insert(new Libro(2L, "La Espada de Fuego", "Cuan gay puede ser?"));
	}

	@GetMapping("/libros")
	public String getAll(Model modelo) {
		modelo.addAttribute("libros", repositorioLibro.getAll());
		return "libros";
	}

	@GetMapping("/libros/{accion}/{id}")
	public String MostrarPantalla(@PathVariable("id") Long id, @PathVariable("accion") String accion, Model modelo) {

		modelo.addAttribute("id", id);
		modelo.addAttribute("accion", accion);

		Libro lib;

		if (id != null && id != 0) {
			lib = repositorioLibro.getById(id);
		} else {
			lib = new Libro(0L, "", "");
		}

		modelo.addAttribute("libro", lib);

		return "libroedit";
	}

	@PostMapping("/libros/{accion}")
	public String EdicionPantalla(@PathVariable("accion") String accion, @Valid Libro libro,
			BindingResult Comprobacion) {

		switch (accion) {
		case "crear":
			repositorioLibro.insert(libro);
			break;
		case "editar":
			repositorioLibro.update(libro);
			break;
		case "borrar":
			repositorioLibro.delete(libro.getId());
			break;
		}

		return "redirect:/libros";
	}
}
