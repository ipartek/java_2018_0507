package com.ipartek.formacion.prestamolibrosspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.prestamolibrosspring.repositories.LibroMapRepository;

@Controller
public class LibroController {
	
		public static final LibroMapRepository repositorioLibro = new LibroMapRepository();

		@GetMapping("/libros")
		public String getAll(Model modelo) {
			modelo.addAttribute("libros", repositorioLibro.getAll());
			return "libros";
		}
		
	
}
