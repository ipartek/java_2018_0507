package com.ipartek.formacion.editorialrestspring.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.editorialrestspring.modelos.Editorial;
import com.ipartek.formacion.editorialrestspring.repositories.CrudAble;

@RestController
public class EditorialController {
	@Autowired
	private final CrudAble<Editorial> repositorio = null;
	
	@GetMapping("/api/editoriales")
	public List<Editorial> obtenerEditoriales() {
		return repositorio.getAll();
	}
	
	@GetMapping("/api/editoriales/{id}")
    public Editorial obtenerEditorialPorId(@PathVariable("id") long id) {
    	return repositorio.getById(id);
    }
	
	@PostMapping("/api/editoriales")
	public Long crearNuevaEditorial(@RequestBody Editorial editorial) {
		return repositorio.insert(editorial);
	}
	
	@PutMapping("/api/editoriales")
	public void modificarEditorial(@RequestBody Editorial editorial) {
		repositorio.update(editorial);
	}
	
	@DeleteMapping("/api/editoriales/{id}")
	public void borrarEditorial(@PathVariable("id") long id) {
		repositorio.delete(id);
	}
}
