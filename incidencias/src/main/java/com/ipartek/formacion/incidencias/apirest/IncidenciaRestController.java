package com.ipartek.formacion.incidencias.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ipartek.formacion.incidencias.modelos.Incidencia;
import com.ipartek.formacion.incidencias.repositorios.CrudAble;
import com.ipartek.formacion.incidencias.repositorios.IncidenciaJdbcRepository;

@RestController
public class IncidenciaRestController implements RestAble<Incidencia>{

	@Autowired
	private CrudAble<Incidencia> repositorio;
		
	@Autowired
	private IncidenciaJdbcRepository repositorio2;
	
	@Override
	@GetMapping("/api/incidencias")
	public List<Incidencia> getAll() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/incidencias/{id}")
	public Incidencia getById(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}


	@Override
	@DeleteMapping("/api/incidencias/{id}")
	public void delete(@PathVariable("id") Long id) {
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
	
	@Override
	@PutMapping("/api/incidencias")
	public void update(@RequestBody Incidencia incidencia) {
		repositorio.update(incidencia);
	}

	@Override
	public Long add(Incidencia t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
