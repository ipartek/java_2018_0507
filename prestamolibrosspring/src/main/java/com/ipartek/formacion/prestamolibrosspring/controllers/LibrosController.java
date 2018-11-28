package com.ipartek.formacion.prestamolibrosspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.model.Libro;
import com.ipartek.formacion.prestamolibrosspring.repositories.CrudAble;
import com.ipartek.formacion.prestamolibrosspring.repositories.EditorialMapRepository;
import com.ipartek.formacion.prestamolibrosspring.repositories.LibroMapRepository;

@Controller
public class LibrosController {
	
	//Como lleva el @Autowired la clase EditorialMaoRepository se autorellena
	@Autowired
	//private LibroMapRepository repositoriolib=null;// = new LibroMapRepository();
	private CrudAble<Libro> repositoriolib=null;
	@Autowired
	//private EditorialMapRepository repositorioedit=null;  
	//PARA QUE SE RELLENE CON LO DE LA BD SE PONE LA LINEA DE ABAJO-- Este llama al crudable y es el que maneja
	//la conexion con la bd que esta en el properties
	private CrudAble<Editorial> repositorioedit=null;
	
		
	@GetMapping("/libros")
	public String getAll(Model modelo) {
		modelo.addAttribute("libros", repositoriolib.getAll());
		return "libros";
	}
	
	@GetMapping("/libros/{accion}/{id}") 
	public String mostrarPantalla(
			@PathVariable("id") Long id, @PathVariable("accion") String accion, Model modelo) {
		
		modelo.addAttribute("id", id);
		modelo.addAttribute("accion", accion);
		
		Libro libro;
		
		if(id != null && id != 0L) {
			libro = repositoriolib.getById(id);
		} else {
			libro = new Libro("","",0L,0);
		}
		
			List<Editorial> editoriales=repositorioedit.getAll();
			
			for (Editorial string : editoriales) {
		        System.out.println(string);
		    }
			
		modelo.addAttribute("libro", libro);
		modelo.addAttribute("editoriales",editoriales);
		
		
		return "libro";
	}
	
	@PostMapping("/libros/{accion}")
	public String procesarPantalla(
			@PathVariable(value="accion") String accion, 
			@Valid Libro libro, BindingResult bindingResult) {
	
		
		if (!accion.equals("borrar") && bindingResult.hasErrors()) {
            return "libro";
        }
		
		System.out.println("Libro a insertar" + libro.getTitulo());
	
		switch(accion) {
		case "crear": 
			System.out.println("ainsertar");
			repositoriolib.insert(libro);
			break;
		case "editar":
			repositoriolib.update(libro);
			break;
		case "borrar":
			repositoriolib.delete((long) libro.getId());
			break;
		}
		
        return "redirect:/libros";
	}
}
