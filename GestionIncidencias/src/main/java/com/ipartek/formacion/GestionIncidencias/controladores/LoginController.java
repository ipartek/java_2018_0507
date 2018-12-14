package com.ipartek.formacion.GestionIncidencias.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.GestionIncidencias.modelos.Usuario;
import com.ipartek.formacion.GestionIncidencias.repositorios.UsuarioRepository;

@RestController
public class LoginController {

	@Autowired
	private UsuarioRepository repositorio;
	
	@GetMapping("/api/login")
	public Usuario obtenerUsuario() {
		return repositorio.getById(1L);
	}
	
	@GetMapping("/api/usuarios/search")
	public Usuario searchUser(@RequestBody Usuario usuario) {
		return repositorio.searchUser(usuario);
	}
	
	@PostMapping("/api/login")
	public String comprobarUsuario(@RequestBody Usuario usuario) {
		
		
		return "false";
	}
}
