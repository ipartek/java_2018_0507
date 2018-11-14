package com.ipartek.formacion.prestamolibrosspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.repositories.EditorialMapRepository;

@Controller
public class EditorialController {
	@Autowired
	private final EditorialMapRepository repositorio = null;
	
	@GetMapping("/editoriales")
	public String getAll(Model modelo) {
		modelo.addAttribute("editoriales", repositorio.getAll());
		return "editoriales";
	}
	
	@GetMapping("/editoriales/{accion}/{id}") 
	public String mostrarPantalla(
			@PathVariable("id") Long id, @PathVariable("accion") String accion, Model modelo) {
		
		modelo.addAttribute("id", id);
		modelo.addAttribute("accion", accion);
		
		Editorial editorial;
		
		if(id != null && id != 0L) {
			editorial = repositorio.getById(id);
		} else {
			editorial = new Editorial(0L, "");
		}
		
		modelo.addAttribute("editorial", editorial);
		
		return "editorial";
	}
	
	@PostMapping("/editoriales/{accion}")
	public String procesarPantalla(
			@PathVariable(value="accion") String accion, 
			@Valid Editorial editorial, BindingResult bindingResult) {
		
		if (!accion.equals("borrar") && bindingResult.hasErrors()) {
            return "editorial";
        }

		switch(accion) {
		case "crear": 
			repositorio.insert(editorial);
			break;
		case "editar":
			repositorio.update(editorial);
			break;
		case "borrar":
			repositorio.delete(editorial.getId());
			break;
		}
		
        return "redirect:/editoriales";
	}
}
