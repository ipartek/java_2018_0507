package com.ipartek.formacion.prestamolibrosspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.repositories.EditorialMapRepository;

@Controller
public class EditorialController {
	//TODO: Hacerlo por inyección de dependencia (Spring)
	private static final EditorialMapRepository repositorio = new EditorialMapRepository();
	
	static {
		repositorio.insert(new Editorial(1L, "Anaya"));
		repositorio.insert(new Editorial(2L, "McGraw Hill"));
	}
	
	@GetMapping("/editoriales")
	public String getAll(Model modelo) {
		modelo.addAttribute("editoriales", repositorio.getAll());
		return "editoriales";
	}
	
	@GetMapping("/editoriales/crear") 
	public String mostrarPantallaCrear() {
		return "editorial";
	}

	@GetMapping("/editoriales/{accion}/{id}") 
	public String mostrarPantallaEditar(
			@PathVariable(value="id") Long id, @PathVariable(value="accion") String accion, Model modelo) {
		
		modelo.addAttribute("id", id);
		modelo.addAttribute("accion", accion);
		
		modelo.addAttribute("editorial", repositorio.getById(id));
		
		return "editorial";
	}

}
