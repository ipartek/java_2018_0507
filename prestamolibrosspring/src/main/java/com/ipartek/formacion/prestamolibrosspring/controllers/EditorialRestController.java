package com.ipartek.formacion.prestamolibrosspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.repositories.CrudAble;

@RestController
public class EditorialRestController {
	
	@Autowired
	private CrudAble<Editorial>repositorio;

	@GetMapping("/api/editoriales")
	public List<Editorial> obtenerEditoriales(){
		
		return repositorio.getAll();	
	}
	
	@GetMapping("/api/editoriales/{idrecibido}")
	public Editorial obtenerEditorialPorId(@PathVariable ("idrecibido")Long id) {
		//Editorial editorial = repositorio.getById(id);
		//return editorial;
		
		return repositorio.getById(id);
		
	}
	
	
	@PostMapping("/api/editoriales")
	public Long crearNuevaEditorial(Editorial editorial) {
		return repositorio.insert(editorial);
	}
	
	
	@PutMapping("/api/editoriales/{id}")
	public void cambiarEditorial(@PathVariable("id") Long id, @RequestBody Editorial editorial) {
		repositorio.update(editorial);
		
	}
	
	@DeleteMapping("/api/editoriales/{id}")
	public void eleiminarEditorial(@PathVariable("idrecibido") Long id) {
		repositorio.delete(id);
	}
}
