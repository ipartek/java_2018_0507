package com.ipartek.formacion.ejercicios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejercicios.modelo.Incidencia;
import com.ipartek.formacion.ejercicios.repositories.CrudAble;

@RestController
public class IncidenciaRestController implements CrudAble<Incidencia> {
	
	@Autowired
	private CrudAble<Incidencia> repositorio;

	@GetMapping("/api/incidencias")
	public List<Incidencia> getAll() {
		return repositorio.getAll();
	}

	@GetMapping("/api/incidencias/{id}")
	public Incidencia getById(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@PostMapping("/api/incidencias")
	public void insert(@RequestBody Incidencia inci) {
		repositorio.insert(inci);
		
	}

	@PutMapping("/api/incidencias/{id}")
	public void update(Incidencia t) {
		// TODO Auto-generated method stub
		
	}

	@DeleteMapping ("/api/incidencias/{id}")
	public void delete(@PathVariable("id") Long id) {
		repositorio.delete(id);
		
	}

}
