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

import com.ipartek.formacion.editorialrestspring.modelos.Alumno;
import com.ipartek.formacion.editorialrestspring.repositories.CrudAble;

@RestController
public class AlumnoController implements RestAble<Alumno>{
	@Autowired
	private final CrudAble<Alumno> repositorio = null;
	
	@Override
	@GetMapping("/api/alumnos")
	public List<Alumno> obtenerTodos() {
		return repositorio.getAll();
	}
	
	@Override
	@GetMapping("/api/alumnos/{id}")
    public Alumno obtenerPorId(@PathVariable("id") Long id) {
    	return repositorio.getById(id);
    }
	
	@Override
	@PostMapping("/api/alumnos")
	public Long crear(@RequestBody Alumno alumno) {
		return (Long) repositorio.insert(alumno);
	}
	
	@Override
	@PutMapping("/api/alumnos")
	public void modificar(@RequestBody Alumno alumno) {
		repositorio.update(alumno);
	}
	
	@Override
	@DeleteMapping("/api/alumnos/{id}")
	public void borrar(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}
}
