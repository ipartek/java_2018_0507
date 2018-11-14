package com.ipartek.formacion.prestamolibrosspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/editoriales")
	public String getAll(Model modelo) {
		modelo.addAttribute("editoriales", repositorio.getAll());
		return "editoriales";
	}
}
