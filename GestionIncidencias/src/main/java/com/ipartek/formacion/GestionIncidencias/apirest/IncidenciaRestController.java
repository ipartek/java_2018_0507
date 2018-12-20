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
import com.ipartek.formacion.GestionIncidencias.modelos.Incidencia;
import com.ipartek.formacion.GestionIncidencias.repositorios.CrudAble;
import com.ipartek.formacion.GestionIncidencias.repositorios.HistoricoRepository;
import com.ipartek.formacion.GestionIncidencias.repositorios.IncidenciaRepository;

@RestController
public class IncidenciaRestController implements RestAble<Incidencia>{

	@Autowired
	private CrudAble<Incidencia> repositorio;
	
	private HistoricoRepository repositorioHistorico;
	
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
		Long incidenciaId = (Long) repositorio.insert(incidencia);
		
		incidencia.setId(incidenciaId);
		
		Historico historico = new Historico(null, incidencia, incidencia.getUsuarioCreadorId(), incidencia.getFecha(), incidencia.getDescripcion(), "ABIERTA");

		return repositorioHistorico.insert(historico);
	}

	@Override
	@PutMapping("/api/incidencias")
	public void modificar(@RequestBody Incidencia incidencia) {
		repositorio.update(incidencia);
	}

	@Override
	@DeleteMapping("/api/incidencias/{id}")
	public void borrar(@PathVariable("id") Long id) {
		repositorio.delete(id);
	}
	
	@GetMapping("/api/incidencias/open/{id}")
	public List<Incidencia> obtenerMisIncidenciasPorId(@PathVariable("id") Long id) {
		return repositorio2.getByIdUsuario(id);
	}
	
	@GetMapping("/api/incidencias/buscador/id/{id}")
	public List<Incidencia> obtenerIncidenciaPorId(@PathVariable("id") Long id){
		return repositorio2.searchById(id);
	}
	
	@GetMapping("/api/incidencias/buscador/usuario/{usuario}")
	public List<Incidencia> obtenerIncidenciaPorUsuario(@PathVariable("usuario") String usuario){
		return repositorio2.searchByUsuario(usuario);
	}
	
	@GetMapping("/api/incidencias/buscador/estado/{estado}")
	public List<Incidencia> obtenerIncidenciaPorEstado(@PathVariable("estado") String estado){
		return repositorio2.searchByEstado(estado);
	}
	
}
