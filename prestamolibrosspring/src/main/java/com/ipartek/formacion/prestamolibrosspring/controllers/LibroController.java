package com.ipartek.formacion.prestamolibrosspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.ipartek.formacion.prestamolibrosspring.model.Libro;
import com.ipartek.formacion.prestamolibrosspring.repositories.CrudAble;

@Controller
public class LibroController {
	@Autowired
	private final CrudAble<Libro> repositorio = null;
	
	@GetMapping("/libros")
	public String getAll(Model modelo) {
		modelo.addAttribute("libros", repositorio.getAll());
		return "Libros";
	}
	
	@GetMapping("/libros/{accion}/{id}") 
	public String mostrarPantalla(
			@PathVariable("id") Long id, @PathVariable("accion") String accion, Model modelo) {
		
		modelo.addAttribute("id", id);
		modelo.addAttribute("accion", accion);
		
		Libro libro;
		
		if(id != null && id != 0L) {
			libro = repositorio.getById(id);
		} else {
			libro = new Libro(0L, "","","");
		}
		
		modelo.addAttribute("libro", libro);
		
		return "libro";
	}
	
	@PostMapping("/libros/{accion}")
	public String procesarPantalla(
			@PathVariable(value="accion") String accion, 
			@Valid Libro libro, BindingResult bindingResult) {
		
		if (!accion.equals("borrar") && bindingResult.hasErrors()) {
            return "libro";
        }

		switch(accion) {
		case "crear": 
			repositorio.insert(libro);
			break;
		case "editar":
			repositorio.update(libro);
			break;
		case "borrar":
			repositorio.delete(libro.getId());
			break;
		}
		
        return "redirect:/libros";
	}
}
