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

import com.ipartek.formacion.GestionIncidencias.modelos.Usuario;
import com.ipartek.formacion.GestionIncidencias.repositorios.CrudAble;
import com.ipartek.formacion.GestionIncidencias.repositorios.UsuarioRepository;

@RestController
public class UsuarioRestController implements RestAble<Usuario>{

	@Autowired
	private CrudAble<Usuario> repositorio;
	
	@Autowired
	private UsuarioRepository repositorio2;
	
	@Override
	@GetMapping("/api/usuarios")
	public List<Usuario> obtenerTodos() {
		return repositorio.getAll();
	}

	@Override
	@GetMapping("/api/usuarios/{id}")
	public Usuario obtenerPorId(@PathVariable("id") Long id) {
		return repositorio.getById(id);
	}

	@Override
	@PostMapping("/api/usuarios")
	public Long crear(@RequestBody Usuario usuario) {
		return (Long) repositorio.insert(usuario);
	}

	@Override
	@PutMapping("/api/usuarios")
	public void modificar(@RequestBody Usuario usuario) {
		repositorio.update(usuario);
	}

	@Override
	@DeleteMapping("/api/usuarios/{id}")
	public void borrar(Long id) {
		repositorio.delete(id);
	}
	
	@GetMapping("/api/usuarios/admin")
	public List<Usuario> obtenerAdmins(){
		return repositorio2.getAllAdmins();
	}
}
