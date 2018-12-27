package com.ipartek.formacion.incidencias.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.incidencias.modelos.Usuario;
import com.ipartek.formacion.incidencias.repositorios.CrudAble;
import com.ipartek.formacion.incidencias.repositorios.UsuarioJdbcRepository;

@RestController
public class UsuarioRestController implements RestAble<Usuario>{

	@Autowired
	private CrudAble<Usuario> repositorio;
	
	@Autowired
	private UsuarioJdbcRepository repositorio2;
	
	@Override
	@GetMapping("/api/usuarios")
	public List<Usuario> getAll() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/usuarios/{id}")
	public Usuario getById(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/usuarios")
	public Long add(@RequestBody Usuario usuario) {
		return (Long) repositorio.insert(usuario);
	}

	@Override
	@PutMapping("/api/usuarios")
	public void update(@RequestBody Usuario usuario) {
		repositorio.update(usuario);
	}

	@Override
	@DeleteMapping("/api/usuarios/{id}")
	public void delete(Long id) {
		repositorio.delete(id);
	}
	
	@GetMapping("/api/usuarios/admin")
	public List<Usuario> obtenerAdmins(){
		return repositorio2.getAllAdmins();
	}
}
