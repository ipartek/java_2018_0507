package com.ipartek.formacion.GestionIncidencias.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.GestionIncidencias.modelos.Incidencia;
import com.ipartek.formacion.GestionIncidencias.repositorios.CrudAble;
import com.ipartek.formacion.GestionIncidencias.repositorios.IncidenciaRepository;

@RestController
public class IncidenciaRestController implements RestAble<Incidencia>{

	@Autowired
	private CrudAble<Incidencia> repositorio;
	
	@Autowired
	private IncidenciaRepository repositorio2;
	
	@Override
	@GetMapping("/api/incidencias")
	public List<Incidencia> obtenerTodos() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/incidencias/{id}")
	public Incidencia obtenerPorId(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/incidencias")
	public Long crear(@RequestBody Incidencia incidencia) {
		return (Long) repositorio.insert(incidencia);
	}

	@Override
	@PutMapping("/api/incidencias")
	public void modificar(@RequestBody Incidencia incidencia) {
		repositorio.update(incidencia);
	}

	@Override
	@DeleteMapping("/api/incidencias/{id}")
	public void borrar(Long id) {
		repositorio.delete(id);
	}
	
	@GetMapping("/api/incidencias/open/{id}")
	public List<Incidencia> obtenerMisIncidenciasPorId(@PathVariable("id") Long id) {
		return repositorio2.getByIdUsuario(id);
	}
}
