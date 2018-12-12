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

import com.ipartek.formacion.GestionIncidencias.modelos.Historico;
import com.ipartek.formacion.GestionIncidencias.repositorios.CrudAble;
import com.ipartek.formacion.GestionIncidencias.repositorios.HistoricoRepository;

@RestController
public class HistoricoRestController implements RestAble<Historico>{

	@Autowired
	private CrudAble<Historico> repositorio;
	
	@Autowired
	private HistoricoRepository repositorio2;
	
	@Override
	@GetMapping("/api/historicos")
	public List<Historico> obtenerTodos() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/historicos/{id}")
	public Historico obtenerPorId(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/historicos")
	public Long crear(@RequestBody Historico historico) {
		return (Long) repositorio.insert(historico);
	}

	@Override
	@PutMapping("/api/historicos")
	public void modificar(@RequestBody Historico historico) {
		repositorio.update(historico);
	}

	@Override
	@DeleteMapping("/api/historicos/{id}")
	public void borrar(Long id) {
		repositorio.delete(id);
	}
	
	@GetMapping("/api/historicos/open/{id}")
	public List<Historico> obtenerHistoricoByIncidenciaId(@PathVariable("id") Long id){
		return repositorio2.getHistoricoByIncidenciaId(id);
	}
}
