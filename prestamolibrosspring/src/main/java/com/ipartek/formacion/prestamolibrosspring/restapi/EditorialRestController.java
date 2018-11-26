package com.ipartek.formacion.prestamolibrosspring.restapi;

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
	private CrudAble<Editorial> repositorio;
	
	@GetMapping("/api/editoriales")
	public List<Editorial> obtenerEditoriales() {
		return repositorio.getAll();
	}
	
	@GetMapping("/api/editoriales/{idrecibido}")
	public Editorial obtenerEditorialPorId(@PathVariable("idrecibido") Long id) {
		return repositorio.getById(id);
	}
	
	@PostMapping("/api/editoriales")
	public Long crearNuevaEditorial(@RequestBody Editorial editorial) {
		return repositorio.insert(editorial);
	}
	
	@PutMapping("/api/editoriales")
	public void cambiarEditorial(@RequestBody Editorial editorial) {
		repositorio.update(editorial);
	}
	
	@DeleteMapping("/api/editoriales/{id}")
	public void borrarEditorial(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}
}
